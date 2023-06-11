package org.proj.residencia.repository;

import org.proj.residencia.model.ProdutorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends JpaRepository<ProdutorModel, Long>{
	
	@Query
	ProdutorModel findByCnpj (String cnpj);
	@Query
	ProdutorModel findByEmail(String email);

	
}
