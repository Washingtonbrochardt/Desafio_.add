package com.add.DesafioJavaJr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.add.DesafioJavaJr.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
	public Optional<Escola> findByNome(String nome);
}
