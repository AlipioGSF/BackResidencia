package org.proj.residencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String senha;
	@OneToOne
	@Column(nullable = true)
	private EstabelecimentoModel estabelecimento;
	@OneToOne
	@Column(nullable = true)
	private ProdutorModel produtor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public EstabelecimentoModel getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(EstabelecimentoModel estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public ProdutorModel getProdutor() {
		return produtor;
	}
	public void setProdutor(ProdutorModel produtor) {
		this.produtor = produtor;
	}
	
	
}
