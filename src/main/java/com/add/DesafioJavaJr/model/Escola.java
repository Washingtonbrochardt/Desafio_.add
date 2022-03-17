package com.add.DesafioJavaJr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_escola")
public class Escola {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome é obrigatorio")
	private String nome;
	
	private Endereco endereco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "escola")
	private List<Turma> turmas = new ArrayList<>();
	
	public Escola() {
	}

	public Escola(Long id, String nome, Endereco endereco) {
		
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereço() {
		return endereco;
	}

	public void setEndereço(Endereco endereço) {
		this.endereco = endereço;
	}
	
	

}
