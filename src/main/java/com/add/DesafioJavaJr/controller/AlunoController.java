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

import com.add.DesafioJavaJr.model.Aluno;
import com.add.DesafioJavaJr.repository.AlunoRepository;
import com.add.DesafioJavaJr.service.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private AlunoService service;
	
	@GetMapping("/cadastrados")
	public ResponseEntity<List<Aluno>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Aluno> create(@RequestBody @Valid Aluno aluno) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(aluno).get());
	}
	
	
	@PutMapping("/atualizar")
	public ResponseEntity<Aluno> update(@RequestBody @Valid Aluno aluno){		
	        return service.update(aluno).map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
	        		.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {

		Optional<Aluno> aluno = repository.findById(id);
		if (aluno.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		repository.deleteById(id);
	}

}
