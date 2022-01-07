package com.controlesenhas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "senha")
public class Senha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sen_id;

	private long sen_numero;

	private String sen_senha;
	
	private boolean sen_utilizada;

	private boolean sen_preferencial;

	public long getSen_id() {
		return sen_id;
	}

	public void setSen_id(long sen_id) {
		this.sen_id = sen_id;
	}

	public long getSen_numero() {
		return sen_numero;
	}

	public void setSen_numero(long sen_numero) {
		this.sen_numero = sen_numero;
	}

	public String getSen_senha() {
		return sen_senha;
	}

	public void setSen_senha(String sen_senha) {
		this.sen_senha = sen_senha;
	}

	public boolean isSen_utilizada() {
		return sen_utilizada;
	}

	public void setSen_utilizada(boolean sen_utilizada) {
		this.sen_utilizada = sen_utilizada;
	}

	public boolean isSen_preferencial() {
		return sen_preferencial;
	}

	public void setSen_preferencial(boolean sen_preferencial) {
		this.sen_preferencial = sen_preferencial;
	}



}
