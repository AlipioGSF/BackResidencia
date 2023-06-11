package org.proj.residencia.repository;

import org.proj.residencia.model.EstabelecimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoModel, Long> {

	@Query
	EstabelecimentoModel findByCnpj(String cnpj);

	@Query
	EstabelecimentoModel findByEmail(String email);
}
