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

import com.add.DesafioJavaJr.model.Turma;

import com.add.DesafioJavaJr.repository.TurmaRepository;

import com.add.DesafioJavaJr.service.TurmaService;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TurmaController {

	@Autowired
	private TurmaRepository repository;

	@Autowired
	private TurmaService service;

	@GetMapping("/all")
	public ResponseEntity<List<Turma>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/criar")
	public ResponseEntity<Turma> create(@RequestBody @Valid Turma turma) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(turma).get());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Turma> update(@RequestBody @Valid Turma turma) {
		return service.update(turma).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {

		Optional<Turma> turma = repository.findById(id);
		if (turma.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		repository.deleteById(id);
	}

}