package org.proj.residencia.repository;

import org.proj.residencia.model.ColetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColetaRepository extends JpaRepository<ColetaModel, Long> {
}
