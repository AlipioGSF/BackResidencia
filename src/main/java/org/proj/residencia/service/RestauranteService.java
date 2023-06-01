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
	
	public RestauranteModel getRestauranteById(Long id) {
		return restauranteRepository.findById(id).get();
	}
	
	public List<RestauranteModel> getRestauranteByCnpj(String cnpj) {
		List<RestauranteModel> restaurantes = new ArrayList<>();
		restauranteRepository.findAll().forEach(restaurantes::add);
		return restaurantes.stream().filter(x->x.getCNPJ()==(String)cnpj).toList();
	}
	
	public RestauranteModel saveOrUpdate(RestauranteModel restaurante) {
		restaurante.setId(restaurante.getId());
		return restauranteRepository.save(restaurante);
	}
	
	public void delete(String cnpj) {
		restauranteRepository.deleteById(cnpj);
	}
}
