package com.controlesenhas.appservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlesenhas.model.SenhaChamada;
import com.controlesenhas.repository.SenhaChamadaRepository;

@Service
public class SenhaChamadaAppService {

	@Autowired
	private SenhaChamadaRepository senhaChamadaRepository;

	public void AlterarSenhaChamada(String senha) {
		SenhaChamada senhaChamada = senhaChamadaRepository.BuscarSenhaChamada();
		if (senhaChamada == null) {
			senhaChamada = new SenhaChamada();
			senhaChamada.setSenha("N0000");
			senhaChamada = senhaChamadaRepository.save(senhaChamada);
		}
		senhaChamada.setSenha(senha);
		senhaChamadaRepository.save(senhaChamada);
	}

	public void LimparSenhaChamada() {
		SenhaChamada senhaChamada = senhaChamadaRepository.BuscarSenhaChamada();
		senhaChamada.setSenha("");
		senhaChamadaRepository.save(senhaChamada);
	}

	public String BuscarSenhaChamada() {
		SenhaChamada senhaChamada = senhaChamadaRepository.BuscarSenhaChamada();
		String senha = "";
		if (senhaChamada != null) {
			senha = senhaChamada.getSenha();
		} 
		return senha;
	}

}
