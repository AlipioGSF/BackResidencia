package org.proj.residencia.service;

import java.util.ArrayList;
import java.util.List;

import org.proj.residencia.model.PedidoModel;
import org.proj.residencia.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<PedidoModel> getAllPedidos(){
		List<PedidoModel> pedidos = new ArrayList<PedidoModel>();
		pedidoRepository.findAll().forEach(pedidos::add);
		return pedidos;
	}
	
	public PedidoModel getPedidoById(Long id) {
		return pedidoRepository.findById(id).get();
	}
	
	public PedidoModel saveOrUpdate(PedidoModel pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public void delete(Long id) {
		pedidoRepository.deleteById(id);
	}
	
}
