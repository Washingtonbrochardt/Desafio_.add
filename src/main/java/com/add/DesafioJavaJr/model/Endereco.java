package com.add.DesafioJavaJr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotBlank(message = "O logradouro é obrigatorio")
	private String logradouro;
	
	private String complemento;
	
	@NotBlank(message = "O bairro é obrigatorio")
	private String bairro;
	
	@NotBlank(message = "A cidade é obrigatoria")
	private String cidade;
	
	@NotBlank(message = "O estado é obrigatorio")
	private String estado;
	
	public Endereco() {
	}

	public Endereco(String logradouro, String complemento, String bairro, String cidade, String estado) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
