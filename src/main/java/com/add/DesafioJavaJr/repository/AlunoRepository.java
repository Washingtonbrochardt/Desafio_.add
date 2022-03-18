package com.add.DesafioJavaJr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.add.DesafioJavaJr.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public Optional<Aluno> findByNome(String nome);

}
