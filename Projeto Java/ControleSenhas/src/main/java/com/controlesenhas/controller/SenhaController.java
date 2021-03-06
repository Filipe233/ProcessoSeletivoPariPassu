package com.controlesenhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlesenhas.appservice.SenhaAppService;
import com.controlesenhas.model.Senha;

@RestController
@RequestMapping("/Senha")
public class SenhaController {

	@Autowired
	private SenhaAppService senhaService;

	@PostMapping("/ResgatarSenha")
	public Senha RegastarSenha() throws Exception {
		Senha senha = senhaService.ResgatarSenha();
		return senha;
	}

	@PostMapping("/IncluirSenha")
	public Senha IncluirSenha(boolean preferencial) {
		Senha senha = senhaService.AcrescentarSenha(preferencial);
		return senha;
	}

	@DeleteMapping("/RemoverSenhas")
	public void RemoverSenhas() {
		senhaService.RemoverSenhas();
	}
}
