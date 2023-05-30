package org.proj.residencia.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ColetaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idColeta;
	@Column(nullable = false)
	private Date data;
	@Column(nullable = false)
	private int qnt_barril;
	@Column(nullable = true)
	private String observacao;
	
	public long getIdColeta() {
		return idColeta;
	}
	public void setIdColeta(Long idColeta) {
		this.idColeta = idColeta;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQnt_barril() {
		return qnt_barril;
	}
	public void setQnt_barril(int qnt_barril) {
		this.qnt_barril = qnt_barril;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
