package org.proj.residencia.repository;

import org.proj.residencia.model.RestauranteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteModel, Long> {

	@Query
	RestauranteModel findByCnpj(String cnpj);
}
