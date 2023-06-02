package org.proj.residencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RestauranteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRestaurante;
	@Column(nullable = false, unique = true)
	private String cnpj;
	@Column(nullable = false)
	private String nome;
	@Column
	private int pontos;
	@Column(nullable = false)
	private String endereco;

	public Long getId() {
		return idRestaurante;
	}

	public void setId(Long id) {
		this.idRestaurante = id;
	}

	public String getCNPJ() {
		return cnpj;
	}

	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
