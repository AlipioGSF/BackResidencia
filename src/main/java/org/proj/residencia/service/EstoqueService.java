package org.proj.residencia.service;

import org.proj.residencia.model.EstoqueModel;
import org.proj.residencia.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
	final Integer ID = 1001;
	@Autowired
	EstoqueRepository estoqueRepository;	
	EstoqueModel estoque = estoqueRepository.findById(ID).get();	
	
	public void updateEstoque(int qtd) {
		estoque.setBarris(qtd);
		estoqueRepository.save(estoque);
	}
	
	public void incrementEstoque(int qtd) {
		int totalBarril = estoque.getBarris();
		int novoTotal = totalBarril + qtd;
		updateEstoque(novoTotal);
	}
	
	public void decrementEstoque(int qtd) {
		int totalBarril = estoque.getBarris();
		int novoTotal = totalBarril - qtd;
		updateEstoque(novoTotal);
	}
	
	public int currentEstoque() {
		return estoque.getBarris();
	}
	
}
