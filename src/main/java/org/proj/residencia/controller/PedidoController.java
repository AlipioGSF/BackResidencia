package org.proj.residencia.controller;

import java.util.List;

import org.proj.residencia.model.PedidoModel;
import org.proj.residencia.model.ProdutorModel;
import org.proj.residencia.service.PedidoService;
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

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	ProdutorService produtorService;
	
	@GetMapping
	public ResponseEntity<List<PedidoModel>> getAllPedidos(){
		List<PedidoModel> pedidos = pedidoService.getAllPedidos();
		return new ResponseEntity<>(pedidos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <PedidoModel> getPedidoById(@PathVariable("id")Long id){
		PedidoModel pedido = pedidoService.getPedidoById(id);
		if (pedido != null) {
			return new ResponseEntity<>(pedido, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pedido, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity <PedidoModel> savedPedido(@PathVariable(value="id")Long id,@RequestBody PedidoModel pedido){
			ProdutorModel produtor = produtorService.getProdutorById(id);
			pedido.setProdutor(produtor);
			PedidoModel savedPedido = pedidoService.saveOrUpdate(pedido);
			if(savedPedido != null) {
			return new ResponseEntity<>(savedPedido, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("")
	public ResponseEntity <PedidoModel> updatePedido(@RequestBody PedidoModel pedido){
		PedidoModel existingPedido = pedidoService.getPedidoById(pedido.getIdPedido());
		if (existingPedido != null) {
			PedidoModel updatePedido = pedidoService.saveOrUpdate(pedido);
			return new ResponseEntity<>(updatePedido, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Void> deletePedido(@PathVariable ("id") long id){
		PedidoModel existingPedido = pedidoService.getPedidoById(id);
		if (existingPedido != null) {
			pedidoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
}
