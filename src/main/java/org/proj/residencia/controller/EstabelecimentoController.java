package org.proj.residencia.controller;

import java.util.List;

import org.proj.residencia.model.ColetaModel;
import org.proj.residencia.model.EstabelecimentoModel;
import org.proj.residencia.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<EstabelecimentoModel>> getAllEstabelecimentos() {
		List<EstabelecimentoModel> estabelecimentos = estabelecimentoService.getAllEstabelecimentos();
		return new ResponseEntity<>(estabelecimentos, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<EstabelecimentoModel> getRestauranteById(@PathVariable("id") Long id) {
		EstabelecimentoModel estabelecimento = estabelecimentoService.getEstabelecimentoById(id);
		if (estabelecimento != null) {
			return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@CrossOrigin
	@GetMapping(path = "/{cnpj}")
	public ResponseEntity<EstabelecimentoModel> getRestauranteByCnpj(@PathVariable("cnpj") String cnpj) {
		EstabelecimentoModel estabelecimento = estabelecimentoService.getEstabelecimentoByCnpj(cnpj);
		if (estabelecimento != null) {
			return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@GetMapping("/{id}/coletas")
	public ResponseEntity<List<ColetaModel>> getColetas(@PathVariable("id") Long id){
		EstabelecimentoModel estabelecimento = estabelecimentoService.getEstabelecimentoById(id);
		if (estabelecimento != null){
			if(estabelecimento.getColetas()!=null) {
				return new ResponseEntity<>(estabelecimento.getColetas(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<EstabelecimentoModel> saveRestaurante(@RequestBody EstabelecimentoModel estabelecimento) {
		Check check = new SafeguardCheck();
		boolean hasError = check.elementOf(estabelecimento.getCnpj(), ParametroTipo.CNPJ).validate().hasError();
		if (!hasError) {
			EstabelecimentoModel savedEstabelecimento = estabelecimentoService.saveOrUpdate(estabelecimento);
			return new ResponseEntity<>(savedEstabelecimento, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	@CrossOrigin
	@PutMapping("")
	public ResponseEntity<EstabelecimentoModel> updateRestaurante(@RequestBody EstabelecimentoModel restaurante) {
		EstabelecimentoModel existingRestaurante = estabelecimentoService.getEstabelecimentoByCnpj(restaurante.getCnpj());
		if (existingRestaurante != null) {
			EstabelecimentoModel updatedRestaurante = estabelecimentoService.saveOrUpdate(restaurante);
			return new ResponseEntity<>(updatedRestaurante, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@CrossOrigin
	@DeleteMapping("/{cnpj}")
	public ResponseEntity<Void> deleteRestaurante(@PathVariable("cnpj") String cnpj) {
		EstabelecimentoModel existingRestaurante = estabelecimentoService.getEstabelecimentoByCnpj(cnpj);
		if (existingRestaurante != null) {
			estabelecimentoService.delete(existingRestaurante);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
