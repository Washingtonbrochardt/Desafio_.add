package com.add.DesafioJavaJr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import com.add.DesafioJavaJr.model.Endereco;
import com.add.DesafioJavaJr.repository.EnderecoRepository;

public class EnderecoController {

	@Autowired
	EnderecoRepository repository;
	
	@PostMapping("/criar")
	public ResponseEntity<Endereco> create(Endereco endereco) {
		return ResponseEntity.ok().body(repository.save(endereco));
	}
	
	@GetMapping("/cadastrados")
	public ResponseEntity<List<Endereco>> getAll() {
		List<Endereco> endereco = repository.findAll();
		return ResponseEntity.ok().body(endereco);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Endereco> update(Endereco endereco) {
		verificar(endereco.getId());
		repository.save(endereco);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {

		Optional<Endereco> endereco = repository.findById(id);
		if (endereco.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		repository.deleteById(id);
	}
	
	 private Endereco verificar(Long id){
	        return repository.findById(id).orElseThrow();
	    }

}
