package org.proj.residencia.controller;

import java.util.List;

import org.proj.residencia.model.RestauranteModel;
import org.proj.residencia.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	@GetMapping
	public ResponseEntity<List<RestauranteModel>> getAllRestaurantes() {
		List<RestauranteModel> restaurantes = restauranteService.getAllRestaurantes();
		return new ResponseEntity<>(restaurantes, HttpStatus.OK);
	}
	
	@GetMapping("/{cnpj}")
	public ResponseEntity<RestauranteModel> getRestauranteById(@PathVariable("cnpj") String cnpj) {
		RestauranteModel restaurante = restauranteService.getRestauranteById(cnpj);
		if (restaurante != null) {
			return new ResponseEntity<>(restaurante, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<RestauranteModel> saveRestaurante(@RequestBody RestauranteModel restaurante) {
		RestauranteModel savedRestaurante = restauranteService.saveOrUpdate(restaurante);
		return new ResponseEntity<>(savedRestaurante, HttpStatus.CREATED);
	}
	
	@PutMapping("/{cnpj}")
	public ResponseEntity<RestauranteModel> updateRestaurante(
			@PathVariable("cnpj") String cnpj,
			@RequestBody RestauranteModel restaurante) {
		RestauranteModel existingRestaurante = restauranteService.getRestauranteById(cnpj);
		if (existingRestaurante != null) {
			restaurante.setCpnj(cnpj);
			RestauranteModel updatedRestaurante = restauranteService.saveOrUpdate(restaurante);
			return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{cnpj}")
	public ResponseEntity<Void> deleteRestaurante(@PathVariable("cnpj") String cnpj) {
		RestauranteModel existingRestaurante = restauranteService.getRestauranteById(cnpj);
		if (existingRestaurante != null) {
			restauranteService.delete(cnpj);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}


