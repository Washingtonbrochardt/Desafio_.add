package com.add.DesafioJavaJr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.add.DesafioJavaJr.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	public Optional<Turma> findByNome(String nome);
}
