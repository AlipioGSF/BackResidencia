package org.proj.residencia.service;

import org.proj.residencia.model.UserModel;
import org.proj.residencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository; 
	
	public UserModel getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
	
}
