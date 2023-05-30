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
	RestauranteRepository restauranteRepository;
	
	public List<RestauranteModel> getAllRestaurantes(){
		List<RestauranteModel> restaurantes = new ArrayList<RestauranteModel>();
		restauranteRepository.findAll()
			.forEach(restaurante -> restaurantes.add(restaurante));
		return restaurantes;
	}
	
	public RestauranteModel getRestauranteById(String id) {
		return restauranteRepository.findById(id).get();
	}
	
	public void saveOrUpdate(RestauranteModel restaurante) {
		restauranteRepository.save(restaurante);
	}
	 public void delete(String id) {
		 restauranteRepository.deleteById(id);
	 }
	
	
}
