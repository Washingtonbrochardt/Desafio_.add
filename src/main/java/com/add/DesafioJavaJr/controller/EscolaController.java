package com.add.DesafioJavaJr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.add.DesafioJavaJr.model.Escola;

import com.add.DesafioJavaJr.repository.EscolaRepository;

import com.add.DesafioJavaJr.service.EscolaService;

@RestController
@RequestMapping("/escolas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EscolaController {
	
	@Autowired
	private EscolaRepository repository;
	
	@Autowired
	private EscolaService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<Escola>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Escola> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Escola> create(@RequestBody @Valid Escola escola) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(escola).get());
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<Escola> update(@RequestBody @Valid Escola escola){		
	        return service.update(escola).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
	        		.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {

		Optional<Escola> escola = repository.findById(id);
		if (escola.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		repository.deleteById(id);
	}

}
