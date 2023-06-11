package org.proj.residencia.service;

import org.proj.residencia.model.EstabelecimentoModel;
import org.proj.residencia.model.ProdutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	EstabelecimentoService estabelecimentoService;
	@Autowired
	ProdutorService produtorService;
	
	public boolean checkSenha(ProdutorModel user, String senha) {
		return user.getSenha().equals(senha);
	}
	
	public boolean checkSenha(EstabelecimentoModel user, String senha) {	
		return user.getSenha().equals(senha);
	}
	
	
	
	
}
