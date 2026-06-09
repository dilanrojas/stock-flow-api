package com.stockflow.stockflow_backend.services.MovementService;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.entities.Movement;

public interface IMovementService {
    Page<Movement> getAll(int page);
    Movement createMovement(MovementRequestDTO dto);
}
