package com.stockflow.stockflow_backend.facade.MovementFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementDTO;
import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.entities.Movement;
import com.stockflow.stockflow_backend.mappers.MovementMapper;
import com.stockflow.stockflow_backend.services.MovementService.IMovementService;

import jakarta.transaction.Transactional;

@Component
public class MovementFacade implements IMovementFacade {

    @Autowired
    private IMovementService movementService;

    @Autowired
    private MovementMapper movementMapper;

    @Override
    public Page<MovementDTO> getAll(int page) {
        Page<Movement> movementPage = movementService.getAll(page);

        return movementMapper.toMovementDTOPage(movementPage);
    }

    @Override
    @Transactional
    public MovementDTO createMovement(MovementRequestDTO dto) {
        Movement movement = movementService.createMovement(dto);
        return movementMapper.toMovementDTO(movement);
    }
}
