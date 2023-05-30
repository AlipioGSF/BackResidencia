package org.proj.residencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RestauranteModel {
	@Id
	private String cpnj; 
	@Column
	private String nome;
	@Column
	private int pontos;
	@Column
	private String endereco;
	
	public String getCpnj() {
		return cpnj;
	}
	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
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
