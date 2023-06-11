package org.proj.residencia.service;

import org.proj.residencia.model.EnderecoModel;
import org.proj.residencia.model.EstabelecimentoModel;
import org.proj.residencia.model.ProdutorModel;
import org.proj.residencia.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	@Autowired
	ProdutorService produtorService;
	
	
	public EstabelecimentoModel registerEstabelecimento(UserData userData) {
			EstabelecimentoModel estabelecimento = new EstabelecimentoModel();
			EnderecoModel endereco = new EnderecoModel();
			endereco.setCidade(userData.getCidade());
			endereco.setEstado(userData.getEstado());
			endereco.setNumero(userData.getNumero());
			endereco.setRua(userData.getRua());
			estabelecimento.setEmail(userData.getEmail());
			estabelecimento.setSenha(userData.getSenha());
			estabelecimento.setCnpj(userData.getCnpj());
			estabelecimento.setEndereco(endereco);
			estabelecimento.setNome(userData.getNome());
			estabelecimentoService.saveOrUpdate(estabelecimento);	
			return estabelecimento;
	}
	
	public ProdutorModel registerProdutor(UserData userData) {
		ProdutorModel produtor = new ProdutorModel();
		EnderecoModel endereco = new EnderecoModel();
		endereco.setCidade(userData.getCidade());
		endereco.setEstado(userData.getEstado());
		endereco.setNumero(userData.getNumero());
		endereco.setRua(userData.getRua());
		produtor.setEmail(userData.getEmail());
		produtor.setSenha(userData.getSenha());
		produtor.setCnpj(userData.getCnpj());
		produtor.setEndereco(endereco);
		produtor.setNome(userData.getNome());
		produtorService.saveOrUpdate(produtor);	
		return produtor;
	}
	
	
}
