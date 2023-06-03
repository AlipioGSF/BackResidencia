package org.proj.residencia.controller;

import java.util.List;

import org.proj.residencia.model.ColetaModel;
import org.proj.residencia.service.ColetaService;

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

@RestController
@RequestMapping("/coletas")
public class ColetaController {
	
	@Autowired
	private ColetaService coletaService;
	
	@GetMapping
	public ResponseEntity<List<ColetaModel>>  getAllColetas(){
		List<ColetaModel> coletas = coletaService.getAllColetas();
		return new ResponseEntity<>(coletas, HttpStatus.OK);
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity <ColetaModel> getColetasById(@PathVariable("id") Long id){
		ColetaModel coleta = coletaService.getColetaById(id);
		if (coleta != null) {
			return new ResponseEntity<>(coleta, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(coleta, HttpStatus.NOT_FOUND);
		}	
	}
	
	@PostMapping("")
	public ResponseEntity <ColetaModel> saveColeta(@RequestBody ColetaModel coleta){
		Check check = new SafeguardCheck();
		boolean hasError = check.elementOf(coleta.getIdColeta()).validate().hasError();
		if(!hasError) {
			ColetaModel savedColeta = coletaService.saveOrUpdate(coleta);
			return new ResponseEntity<>(savedColeta, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("")
	public ResponseEntity <ColetaModel> updateColeta(@RequestBody ColetaModel coleta){
		ColetaModel existingColeta = coletaService.getColetaById(coleta.getIdColeta());
		if (existingColeta != null) {
			ColetaModel updateColeta = coletaService.saveOrUpdate(coleta);
			return new ResponseEntity<>(updateColeta, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> deleteColetas(@PathVariable ("id") long id){
		ColetaModel existingColeta = coletaService.getColetaById(id);
		if (existingColeta != null) {
			coletaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
}
