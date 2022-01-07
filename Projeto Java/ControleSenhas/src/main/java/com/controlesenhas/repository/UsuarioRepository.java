package com.controlesenhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controlesenhas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select u from usuario u where u.usu_nome = :usuario and u.usu_senha = :senha")
	public Usuario buscarLogin(String usuario, String senha);

}
