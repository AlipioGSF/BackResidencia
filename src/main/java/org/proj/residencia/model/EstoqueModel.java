package org.proj.residencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EstoqueModel {

	@Id
	private Integer idEstoque = 1001;

	@Column
	private int barris; 
	
	
	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getBarris() {
		return barris;
	}

	public void setBarris(int barris) {
		this.barris = barris;
	}
}
