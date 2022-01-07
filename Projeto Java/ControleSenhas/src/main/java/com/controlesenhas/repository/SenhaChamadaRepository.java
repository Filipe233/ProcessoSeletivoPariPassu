package com.controlesenhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.controlesenhas.model.SenhaChamada;

public interface SenhaChamadaRepository extends JpaRepository<SenhaChamada, Long> {

	@Query("SELECT sc from senhachamada sc")
	public SenhaChamada BuscarSenhaChamada();
}
