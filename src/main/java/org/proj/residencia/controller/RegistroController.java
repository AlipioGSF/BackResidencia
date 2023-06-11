package org.proj.residencia.controller;

import org.proj.residencia.model.EstabelecimentoModel;
import org.proj.residencia.model.ProdutorModel;
import org.proj.residencia.model.UserData;
import org.proj.residencia.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;

@RestController
@RequestMapping("/registro")
public class RegistroController {
	@Autowired
	RegisterService registerService;
	
	@PostMapping("")
	public ResponseEntity<?> fazerRegistro(@RequestBody UserData userData){
		Check check = new SafeguardCheck();
		boolean hasError = check.elementOf(userData.getCnpj(), ParametroTipo.CNPJ).validate().hasError();
		if(!hasError) {
			if(userData.getType().equals("estabelecimento")) {
				EstabelecimentoModel estabelecimento = registerService.registerEstabelecimento(userData);
				return new ResponseEntity<>(estabelecimento, HttpStatus.CREATED);
			}else {
				ProdutorModel produtor = registerService.registerProdutor(userData);
				return new ResponseEntity<>(produtor, HttpStatus.CREATED);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
