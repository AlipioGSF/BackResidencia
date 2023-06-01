package org.proj.residencia.service;

import java.util.ArrayList;
import java.util.List;

import org.proj.residencia.model.RestauranteModel;
import org.proj.residencia.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public List<RestauranteModel> getAllRestaurantes(){
		List<RestauranteModel> restaurantes = new ArrayList<>();
		restauranteRepository.findAll().forEach(restaurantes::add);
		return restaurantes;
	}
	
	public RestauranteModel getRestauranteById(String cnpj) {
		return restauranteRepository.findById(cnpj).orElse(null);
	}
	
	public RestauranteModel saveOrUpdate(RestauranteModel restaurante) {
		return restauranteRepository.save(restaurante);
	}
	
	public void delete(String cnpj) {
		restauranteRepository.deleteById(cnpj);
	}
}
