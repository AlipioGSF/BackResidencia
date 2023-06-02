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

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;

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

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<RestauranteModel> getRestauranteById(@PathVariable("id") Long id) {
		RestauranteModel restaurante = restauranteService.getRestauranteById(id);
		if (restaurante != null) {
			return new ResponseEntity<>(restaurante, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/{cnpj}")
	public ResponseEntity<RestauranteModel> getRestauranteByCnpj(@PathVariable("cnpj") String cnpj) {
		RestauranteModel restaurante = restauranteService.getRestauranteByCnpj(cnpj);
		if (restaurante != null) {
			return new ResponseEntity<>(restaurante, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<RestauranteModel> saveRestaurante(@RequestBody RestauranteModel restaurante) {
		Check check = new SafeguardCheck();
		boolean hasError = check.elementOf(restaurante.getCNPJ(), ParametroTipo.CNPJ).validate().hasError();
		if (!hasError) {
			RestauranteModel savedRestaurante = restauranteService.saveOrUpdate(restaurante);
			return new ResponseEntity<>(savedRestaurante, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("")
	public ResponseEntity<RestauranteModel> updateRestaurante(@RequestBody RestauranteModel restaurante) {
		RestauranteModel existingRestaurante = restauranteService.getRestauranteByCnpj(restaurante.getCNPJ());
		if (existingRestaurante != null) {
			RestauranteModel updatedRestaurante = restauranteService.saveOrUpdate(restaurante);
			return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{cnpj}")
	public ResponseEntity<Void> deleteRestaurante(@PathVariable("cnpj") String cnpj) {
		RestauranteModel existingRestaurante = restauranteService.getRestauranteByCnpj(cnpj);
		if (existingRestaurante != null) {
			restauranteService.delete(existingRestaurante);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
