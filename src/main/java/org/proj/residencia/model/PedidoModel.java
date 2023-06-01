package org.proj.residencia.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PedidoModel 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private int quantidade_barris;
    
    @Column(nullable = false)
    private Date data;
    
	@Column(nullable = false)
	private double valor;

	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}

	public int getQuantidade_barris() 
	{
		return quantidade_barris;
	}
	public void setQuantidade_barris(int quantidade_barris) 
	{
		this.quantidade_barris = quantidade_barris;
	}

	public double getValor() 
	{
		return valor;
	}
	public void setValor(double valor) 
	{
		this.valor = valor;
	}

	public Date getData() 
	{
		return data;
	}
	public void setData(Date data) 
	{
		this.data = data;
	}
	
	
	
}
