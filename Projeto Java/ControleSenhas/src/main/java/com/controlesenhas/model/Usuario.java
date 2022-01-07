package com.controlesenhas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usu_id;

	@Column(nullable = false)
	private String usu_nome;

	@Column(nullable = false)
	private String usu_senha;


	private boolean usu_gerente;

	public long getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(long usu_id) {
		this.usu_id = usu_id;
	}

	public String getUsu_senha() {
		return usu_senha;
	}

	public void setUsu_senha(String usu_senha) {
		this.usu_senha = usu_senha;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}


	public boolean isUsu_gerente() {
		return usu_gerente;
	}

	public void setUsu_gerente(boolean usu_gerente) {
		this.usu_gerente = usu_gerente;
	}

}
