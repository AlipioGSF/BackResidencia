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
		produtorRepository.findAll()
			.forEach(produtor -> produtores.add(produtor));
		return produtores;
	}
	
	public ProdutorModel getProdutorById(String id) {
		return produtorRepository.findById(id).get();
	}
	
	public void saveOrUpdate(ProdutorModel produtor) {
		produtorRepository.save(produtor);
	}
	
	public void delete(String id) {
		produtorRepository.deleteById(id);
	}
}
