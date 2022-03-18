package com.add.DesafioJavaJr.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.add.DesafioJavaJr.model.Turma;

import com.add.DesafioJavaJr.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	
	public Optional<Turma> create(Turma turma) {

		if (repository.findByNome(turma.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Turma já existe!", null);

		
		return Optional.of(repository.save(turma));

	}
	
	public Optional<Turma> update(Turma turma) {

		if (repository.findById(turma.getId()).isPresent()) {
			Optional<Turma> buscaTurma = repository.findByNome(turma.getNome());
			if (buscaTurma.isPresent()) {
				if (buscaTurma.get().getId() != turma.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Turma já existe!", null);
			}

			return Optional.of(repository.save(turma));
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Turma não encontrada!", null);
	}

}
