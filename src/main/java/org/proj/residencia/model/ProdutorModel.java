package org.proj.residencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class ProdutorModel 
{
	@Id
	private String cnpj;
	
	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String nome;
	
	public String getCNPJ() 
	{
		return cnpj;
	}
	public void setCNPJ(String cnpj) 
	{
		this.cnpj = cnpj;
	}

	public String getEndereco() 
	{
		return endereco;
	}
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
}
