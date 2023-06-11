package org.proj.residencia.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidoModel 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    
    @Column(nullable = false)
    private int quantidade_barris;
    
    @Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
    private Date data;
    
	@Column(nullable = false)
	private double valor;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_produtor")
	@JsonIgnore
	private ProdutorModel produtor;


	public Long getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}


	public int getQuantidade_barris() {
		return quantidade_barris;
	}


	public void setQuantidade_barris(int quantidade_barris) {
		this.quantidade_barris = quantidade_barris;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public ProdutorModel getProdutor() {
		return produtor;
	}


	public void setProdutor(ProdutorModel produtor) {
		this.produtor = produtor;
	}
	
	
	
}
