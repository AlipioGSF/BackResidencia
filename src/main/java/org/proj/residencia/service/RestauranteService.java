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
	static
	RestauranteRepository restauranteRepository;
	
	public static List<RestauranteModel> getAllRestaurantes(){
		List<RestauranteModel> restaurantes = new ArrayList<RestauranteModel>();
		restauranteRepository.findAll()
			.forEach(restaurante -> restaurantes.add(restaurante));
		return restaurantes;
	}
	
	public static RestauranteModel getRestauranteById(String id) {
		return restauranteRepository.findById(id).get();
	}
	
	public static RestauranteModel saveOrUpdate(RestauranteModel restaurante) {
		return restauranteRepository.save(restaurante);
	}
	 public static void delete(String id) {
		 restauranteRepository.deleteById(id);
	 }
	
	
}
