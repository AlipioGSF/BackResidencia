package org.proj.residencia.service;

import java.util.ArrayList;
import java.util.List;

import org.proj.residencia.model.ColetaModel;
import org.proj.residencia.repository.ColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColetaService {
	@Autowired
	ColetaRepository coletaRepository;
	
	public List<ColetaModel> getAllColetas(){
		List<ColetaModel> coletas = new ArrayList<ColetaModel>();
		coletaRepository.findAll().forEach(coletas::add);
		return coletas;
	}
	
	public ColetaModel getColetaById(Long id) {
		return coletaRepository.findById(id).get();
	}
	
	public ColetaModel saveOrUpdate(ColetaModel coleta) {
		return coletaRepository.save(coleta);
	}
	
	public void delete(Long id) {
		coletaRepository.deleteById(id);
	}
}
