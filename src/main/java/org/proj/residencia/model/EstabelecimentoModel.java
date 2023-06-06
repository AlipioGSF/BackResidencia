package org.proj.residencia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class EstabelecimentoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEstabelecimento;
	@Column(nullable = false, unique = true)
	private String cnpj;
	@Column(nullable = false)
	private String nome;
	@Column
	private int pontos;
	@Column(nullable = false)
	private String endereco;
	
	@OneToMany
	@JoinColumn(name = "id_estabelecimento")
	@JsonIgnore
	private List<ColetaModel> coletas;

	public Long getId() {
		return idEstabelecimento;
	}

	public void setId(Long id) {
		this.idEstabelecimento = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
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

	public List<ColetaModel> getColetas() {
		return coletas;
	}

	public void setColetas(List<ColetaModel> coletas) {
		this.coletas = coletas;
	}
	
	
}
