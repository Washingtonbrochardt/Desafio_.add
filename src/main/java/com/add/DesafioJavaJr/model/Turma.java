package com.add.DesafioJavaJr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_turma")
public class Turma {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome é obrigatorio")
	private String nome;
	
	private long capacidade;
	
	@ManyToOne
	@JoinColumn(name = "escola_id")
	private Escola escola;
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Turma() {
	}

	public Turma(Long id, String nome, Long capacidade, Escola escola) {
		super();
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.escola = escola;
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

	public long getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(long capacidade) {
		this.capacidade = capacidade;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
	
	

}
