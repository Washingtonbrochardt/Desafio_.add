package com.add.DesafioJavaJr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.add.DesafioJavaJr.model.Aluno;
import com.add.DesafioJavaJr.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	
	public Optional<Aluno> create(Aluno aluno) {

		if (repository.findByNome(aluno.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno já existe!", null);

		
		return Optional.of(repository.save(aluno));

	}
	
	public Optional<Aluno> update(Aluno aluno) {

		if (repository.findById(aluno.getId()).isPresent()) {
			Optional<Aluno> buscaAluno = repository.findByNome(aluno.getNome());
			if (buscaAluno.isPresent()) {
				if (buscaAluno.get().getId() != aluno.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno já existe!", null);
			}

			return Optional.of(repository.save(aluno));
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado!", null);
	}

}
