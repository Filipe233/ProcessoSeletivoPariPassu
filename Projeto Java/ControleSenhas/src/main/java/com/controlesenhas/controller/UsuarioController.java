package com.controlesenhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlesenhas.appservice.UsuarioAppService;
import com.controlesenhas.model.Usuario;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	public UsuarioAppService usuarioService;

	@PostMapping("/Login")
	public Usuario Logar(String nome, String senha) throws Exception {
		Usuario usuario = usuarioService.verificarLogin(nome, senha);
		if (usuario == null) {
			throw new Exception("Usuario ou senha incorreta!");
		}

		return usuario;
	}
}
