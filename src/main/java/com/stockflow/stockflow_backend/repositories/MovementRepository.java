package com.stockflow.stockflow_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.stockflow_backend.entities.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    Optional<Movement> findByResourceId(UUID resourceId);
}
