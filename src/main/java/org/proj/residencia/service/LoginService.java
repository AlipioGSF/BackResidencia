package org.proj.residencia.service;

import org.proj.residencia.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	EstabelecimentoService estabelecimentoService;
	@Autowired
	ProdutorService produtorService;
	
	public boolean checkSenha(UserModel user, String senha) {
		return user.getSenha() == senha;
	}
	
	
	
	
}
