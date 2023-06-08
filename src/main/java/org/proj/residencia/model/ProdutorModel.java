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
public class ProdutorModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutor;
	
	@Column(nullable = false, unique = true)
	private String cnpj;
	
	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String nome;
	
	@OneToMany
	@JoinColumn(name = "id_produtor")
	@JsonIgnore
	private List<PedidoModel> pedidos;

	public Long getId() {
		return idProdutor;
	}

	public void setId(Long idProdutor) {
		this.idProdutor = idProdutor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<PedidoModel> getPedidos() {
		return pedidos;
	}

	public void setPedido(List<PedidoModel> pedido) {
		this.pedidos = pedido;
	}

}
