package com.controlesenhas.appservice;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlesenhas.model.Usuario;
import com.controlesenhas.repository.UsuarioRepository;

@Service
public class UsuarioAppService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario verificarLogin(String usuario, String senha) throws ServiceException{

		Usuario usuarioModel = usuarioRepository.buscarLogin(usuario, senha);
		return usuarioModel;
	}

}
