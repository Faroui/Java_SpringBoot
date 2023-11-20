package com.farouiglsid.query.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farouiglsid.query.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
