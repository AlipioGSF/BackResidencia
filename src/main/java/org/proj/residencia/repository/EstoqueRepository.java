package org.proj.residencia.repository;

import org.proj.residencia.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
}
