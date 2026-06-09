package com.stockflow.stockflow_backend.mappers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementDTO;
import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.entities.Movement;
import com.stockflow.stockflow_backend.models.MovementModels.MovementRequestModel;
import com.stockflow.stockflow_backend.models.MovementModels.MovementResponseModel;

@Component
public class MovementMapper {

    public MovementDTO toMovementDTO(Movement movement) {
        if (movement == null) {
            return null;
        }

        return new MovementDTO(
            movement.getQuantity(),
            movement.getNote(),
            movement.getCreatedAt(),
            movement.getResourceId(),
            movement.getStock().getResourceId()
        );
    }

    public Page<MovementDTO> toMovementDTOPage(Page<Movement> movementPage) {
        if (movementPage == null) {
            return null;
        }

        return movementPage.map(this::toMovementDTO);
    }

    public List<MovementDTO> toMovementDTOList(List<Movement> movements) {
        if (movements == null) {
            return null;
        }

        return movements.stream().map(this::toMovementDTO).toList();
    }

    public MovementResponseModel toMovementResponseModel(MovementDTO dto) {
        if (dto == null) {
            return null;
        }

        return new MovementResponseModel(
            dto.quantity(),
            dto.note(),
            dto.createdAt(),
            dto.resourceId(),
            dto.stockResourceId()
        );
    }

    public Page<MovementResponseModel> toMovementResponseModelPage(Page<MovementDTO> movementDTOPage) {
        if (movementDTOPage == null) {
            return null;
        }

        return movementDTOPage.map(this::toMovementResponseModel);
    }

    public List<MovementResponseModel> toMovementResponseModelList(List<MovementDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream().map(this::toMovementResponseModel).toList();
    }

    public MovementRequestDTO toMovementRequestDTO(MovementRequestModel model) {
        if (model == null) {
            return null;
        }

        MovementRequestDTO dto = new MovementRequestDTO();
        dto.setStockResourceId(model.stockResourceId());
        dto.setQuantity(model.quantity());
        dto.setNote(model.note());
        return dto;
    }
}
