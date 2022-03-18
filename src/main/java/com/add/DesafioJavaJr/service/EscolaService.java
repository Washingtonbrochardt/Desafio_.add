package com.add.DesafioJavaJr.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.add.DesafioJavaJr.model.Escola;

import com.add.DesafioJavaJr.repository.EscolaRepository;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository repository;
	
	
	public Optional<Escola> create(Escola escola) {

		if (repository.findByNome(escola.getNome()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Escola já existe!", null);

		
		return Optional.of(repository.save(escola));

	}
	
	public Optional<Escola> update(Escola escola) {

		if (repository.findById(escola.getId()).isPresent()) {
			Optional<Escola> buscaEscola = repository.findByNome(escola.getNome());
			if (buscaEscola.isPresent()) {
				if (buscaEscola.get().getId() != escola.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Escola já existe!", null);
			}

			return Optional.of(repository.save(escola));
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Escola não encontrada!", null);
	}

}
