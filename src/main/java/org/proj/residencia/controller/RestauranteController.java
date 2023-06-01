package org.proj.residencia.controller;

import java.util.List;

import org.proj.residencia.model.RestauranteModel;
import org.proj.residencia.service.RestauranteService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class RestauranteController {
	
	@RequestMapping(value = "/restaurante", method = RequestMethod.GET)
	public List<RestauranteModel> GetAll(){
		return RestauranteService.getAllRestaurantes();	
	}
	
	@RequestMapping(value="/restaurante", method = RequestMethod.POST)
	public RestauranteModel Create(@Valid @RequestBody RestauranteModel restaurante) {
		return RestauranteService.saveOrUpdate(restaurante);
		
	}
}
