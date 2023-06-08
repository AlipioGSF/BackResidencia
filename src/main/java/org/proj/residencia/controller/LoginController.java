package org.proj.residencia.controller;

import org.proj.residencia.model.LoginBody;
import org.proj.residencia.model.UserModel;
import org.proj.residencia.service.LoginService;
import org.proj.residencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	LoginService loginService;
	
	@RequestMapping()
	public ResponseEntity<UserModel> fazerLogin(@RequestBody LoginBody login){
		UserModel user = userService.getUserByEmail(login.getEmail());
		if(user!=null) {
			boolean validSenha = loginService.checkSenha(user, login.getSenha());
			if(validSenha) {
				return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
			}else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}			
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
