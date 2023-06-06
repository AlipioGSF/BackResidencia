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
public class ColetaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idColeta;
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT-3")
	private Date data;
	@Column(nullable = false)
	private int qnt_barril;
	@Column(nullable = true)
	private String observacao;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_estabelecimento")
	@JsonIgnore
	private EstabelecimentoModel estabelecimento;
	
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
	public EstabelecimentoModel getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
