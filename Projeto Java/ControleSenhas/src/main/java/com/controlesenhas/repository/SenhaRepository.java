package com.controlesenhas.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controlesenhas.model.Senha;

public interface SenhaRepository extends JpaRepository<Senha, Long> {


	@Query("SELECT s from senha s where s.sen_preferencial = :preferencial order by s.sen_numero desc")
	public List<Senha> BuscarUltimaSenha(boolean preferencial);

	@Query("SELECT s from senha s where s.sen_utilizada = false and s.sen_preferencial = :preferencial order by s.sen_numero asc")
	public List<Senha> BuscarPrimeiraSenha(boolean preferencial);
	
}
