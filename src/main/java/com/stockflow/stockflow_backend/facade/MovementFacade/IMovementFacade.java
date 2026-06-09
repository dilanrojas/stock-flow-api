package com.stockflow.stockflow_backend.facade.MovementFacade;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementDTO;
import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;

public interface IMovementFacade {
    Page<MovementDTO> getAll(int page);
    MovementDTO createMovement(MovementRequestDTO dto);
}
