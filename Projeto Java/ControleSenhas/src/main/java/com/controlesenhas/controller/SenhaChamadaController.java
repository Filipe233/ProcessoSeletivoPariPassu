package com.controlesenhas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlesenhas.appservice.SenhaChamadaAppService;

@RestController
@RequestMapping("/SenhaChamada")
public class SenhaChamadaController {

	@Autowired
	private SenhaChamadaAppService senhaChamadaService;

	@GetMapping("/Buscar")
	public String BuscarSenhaChamada() {
		return senhaChamadaService.BuscarSenhaChamada();
	}

}
