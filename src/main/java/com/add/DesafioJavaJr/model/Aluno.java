package com.add.DesafioJavaJr.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotBlank(message = "O nome é obrigatorio")
	private String nome;
	
	@Column(name = "dt_nascimento")
	@NotNull(message = "A data de nascimento é obrigatoria")
	private LocalDate dataDeNascimento;
	
	@NotNull(message = "A turma é obrigatoria.")
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	public Aluno() {
	}

	public Aluno(Long id, String nome, LocalDate dataDeNascimento, Turma turma) {
		
		this.id = id;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.turma = turma;
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

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	

}
