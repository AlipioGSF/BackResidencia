package org.proj.residencia.service;

import java.util.ArrayList;
import java.util.List;

import org.proj.residencia.model.EstabelecimentoModel;
import org.proj.residencia.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	public List<EstabelecimentoModel> getAllEstabelecimentos() {
		List<EstabelecimentoModel> estabelecimentos = new ArrayList<>();
		estabelecimentoRepository.findAll().forEach(estabelecimentos::add);
		return estabelecimentos;
	}

	public EstabelecimentoModel getEstabelecimentoById(Long id) {
		return estabelecimentoRepository.findById(id).get();
	}

	public EstabelecimentoModel getEstabelecimentoByCnpj(String cnpj) {
		return estabelecimentoRepository.findByCnpj(cnpj);
	}

	public EstabelecimentoModel saveOrUpdate(EstabelecimentoModel estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	public void delete(EstabelecimentoModel estabelecimento) {
		estabelecimentoRepository.delete(estabelecimento);
	}

	public EstabelecimentoModel getUserByEmail(String email) {
		estabelecimentoRepository.findByEmail(email);
		return null;
	}
}
