package org.proj.residencia.controller;

import org.proj.residencia.model.EstabelecimentoModel;
import org.proj.residencia.model.LoginBody;
import org.proj.residencia.model.ProdutorModel;
import org.proj.residencia.service.EstabelecimentoService;
import org.proj.residencia.service.LoginService;
import org.proj.residencia.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@Autowired
	EstabelecimentoService estabelecimentoService;
	
	@Autowired
	ProdutorService produtorService;
	
	@RequestMapping("")
	public ResponseEntity<?> fazerLogin(@RequestBody LoginBody login){
		EstabelecimentoModel estabelecimento = estabelecimentoService.getUserByEmail(login.getEmail());
		ProdutorModel produtor = produtorService.getProdutorByEmail(login.getEmail());
		if(produtor!= null) {
			boolean validSenha = loginService.checkSenha(produtor, login.getSenha());
			if(validSenha) {
				return new ResponseEntity<>(produtor, HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}else if(estabelecimento != null) {
			boolean validSenha = loginService.checkSenha(estabelecimento, login.getSenha());
			if(validSenha) {
				return new ResponseEntity<>(estabelecimento, HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}
}
