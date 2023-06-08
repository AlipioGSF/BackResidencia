package org.proj.residencia.service;

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
			estabelecimento.setCnpj(userData.getCnpj());
			estabelecimento.setEndereco(userData.getEndereco());
			estabelecimento.setNome(userData.getNome());
			estabelecimentoService.saveOrUpdate(estabelecimento);	
			return estabelecimento;
	}
	
	public ProdutorModel registerProdutor(UserData userData) {
		ProdutorModel produtor = new ProdutorModel();
		produtor.setCnpj(userData.getCnpj());
		produtor.setEndereco(userData.getEndereco());
		produtor.setNome(userData.getNome());
		produtorService.saveOrUpdate(produtor);	
		return produtor;
	}
	
	
}
