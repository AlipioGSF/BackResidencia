package org.proj.residencia.service;

import java.util.ArrayList;
import java.util.List;

import org.proj.residencia.model.ProdutorModel;
import org.proj.residencia.repository.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutorService {
	
	@Autowired
	ProdutorRepository produtorRepository;
	
	public List<ProdutorModel> getAllProdutores(){
		List<ProdutorModel> produtores = new ArrayList<ProdutorModel>();
		produtorRepository.findAll().forEach(produtores::add);
		return produtores;
	}
	
	public ProdutorModel getProdutorById(Long id) {
		return produtorRepository.findById(id).get();
	}
	
	public ProdutorModel getProdutorByCnpj (String cnpj) {
		return produtorRepository.findByCnpj(cnpj);
	}
	
	public ProdutorModel saveOrUpdate(ProdutorModel produtor) {
		return produtorRepository.save(produtor);
	}
	
	public void delete(ProdutorModel produtor) {
		produtorRepository.delete(produtor);
	}
}
