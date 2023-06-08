package org.proj.residencia.controller;

import java.util.List;

import org.proj.residencia.model.PedidoModel;
import org.proj.residencia.model.ProdutorModel;
import org.proj.residencia.service.ProdutorService;
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
@RequestMapping("/produtor")
public class ProdutorController {

	@Autowired
	private ProdutorService produtorService;

	@GetMapping
	public ResponseEntity<List<ProdutorModel>> getAllProdutores() {
		List<ProdutorModel> produtores = produtorService.getAllProdutores();
		return new ResponseEntity<>(produtores, HttpStatus.OK);
	}

	@GetMapping(path = "/id/{id}")
	public ResponseEntity<ProdutorModel> getProdutorById(@PathVariable("id") Long id) {
		ProdutorModel produtor = produtorService.getProdutorById(id);
		if (produtor != null) {
			return new ResponseEntity<>(produtor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}

	@GetMapping(path = "/{cnpj}")
	public ResponseEntity<ProdutorModel> getProdutorById(@PathVariable("cnpj") String cnpj) {
		ProdutorModel produtor = produtorService.getProdutorByCnpj(cnpj);
		if (produtor != null) {
			return new ResponseEntity<>(produtor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(path = "/{id}/pedidos")
	public ResponseEntity<List<PedidoModel>> getPedidos(@PathVariable("id") Long id){
		ProdutorModel produtor = produtorService.getProdutorById(id);
		if(produtor != null) {
			if(produtor.getPedidos() != null) 
			return new ResponseEntity<>(produtor.getPedidos(), HttpStatus.OK);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("")
	public ResponseEntity<ProdutorModel> saveProdutor(@RequestBody ProdutorModel produtor) {
		Check check = new SafeguardCheck();
		boolean hasError = check.elementOf(produtor.getCnpj(), ParametroTipo.CNPJ).validate().hasError();
		if (!hasError) {
			ProdutorModel savedProdutor = produtorService.saveOrUpdate(produtor);
			return new ResponseEntity<>(savedProdutor, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("")
	public ResponseEntity<ProdutorModel> updateProdutor(@RequestBody ProdutorModel produtor) {
		ProdutorModel existingProdutor = produtorService.getProdutorByCnpj(produtor.getCnpj());
		if (existingProdutor != null) {
			ProdutorModel updatedProdutor = produtorService.saveOrUpdate(produtor);
			return new ResponseEntity<>(updatedProdutor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{cnpj}")
	ResponseEntity<Void> deleteProdutor(@PathVariable("cnpj") String cnpj) {
		ProdutorModel existingProdutor = produtorService.getProdutorByCnpj(cnpj);
		if (existingProdutor != null) {
			produtorService.delete(existingProdutor);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
