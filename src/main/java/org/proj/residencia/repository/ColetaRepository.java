package org.proj.residencia.repository;

import org.proj.residencia.model.ColetaModel;
import org.proj.residencia.model.EstabelecimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetaRepository extends JpaRepository<ColetaModel, Long> {

	@Query
	ColetaModel findByEstabelecimento(EstabelecimentoModel estabelecimento);
}
