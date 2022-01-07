package com.controlesenhas.appservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlesenhas.model.Senha;
import com.controlesenhas.repository.SenhaRepository;

@Service
public class SenhaAppService {

	@Autowired
	private SenhaRepository senhaRepository;
	@Autowired
	private SenhaChamadaAppService senhaChamadaService;
	
	public Senha AcrescentarSenha(boolean preferencial) {
		List<Senha> listaSenhas = senhaRepository.BuscarUltimaSenha(preferencial);
		Senha senha = new Senha();
		long numeroAtual = 0;
		if (listaSenhas.size() > 0) {
			senha = listaSenhas.get(0);
			numeroAtual = senha.getSen_numero();
		}
		Senha novaSenha = new Senha();
		novaSenha.setSen_numero(numeroAtual + 1);
		novaSenha.setSen_preferencial(preferencial);
		novaSenha.setSen_senha((preferencial ? "P" : "N") + String.format("%04d", novaSenha.getSen_numero()));
		novaSenha.setSen_utilizada(false);
		senha = senhaRepository.save(novaSenha);
		return novaSenha;
	}

	public Senha ResgatarSenha() throws Exception {
		List<Senha> listaSenha = senhaRepository.BuscarPrimeiraSenha(true);
		Senha senha = new Senha();
		if (listaSenha.size() == 0) {
			listaSenha = senhaRepository.BuscarPrimeiraSenha(false);
			if (listaSenha.size() == 0) {
				throw new Exception("Não há senhas pendentes para serem chamadas!");
			}
		}
		senha = listaSenha.get(0);
		senha.setSen_utilizada(true);

		senhaChamadaService.AlterarSenhaChamada(senha.getSen_senha());
		return senha;
	}

	public void RemoverSenhas() {
		senhaRepository.deleteAll();
		senhaChamadaService.LimparSenhaChamada();
	}

}
