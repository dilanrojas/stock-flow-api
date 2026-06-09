package com.stockflow.stockflow_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementDTO;
import com.stockflow.stockflow_backend.dtos.MovementDTOs.MovementRequestDTO;
import com.stockflow.stockflow_backend.facade.MovementFacade.IMovementFacade;
import com.stockflow.stockflow_backend.mappers.MovementMapper;
import com.stockflow.stockflow_backend.models.MovementModels.MovementRequestModel;
import com.stockflow.stockflow_backend.models.MovementModels.MovementResponseModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/movements")
public class MovementController {

    @Autowired
    private IMovementFacade movementFacade;

    @Autowired
    private MovementMapper movementMapper;

    @GetMapping
    public ResponseEntity<Page<MovementResponseModel>> getAll(@RequestParam(defaultValue = "0") int page) {
        Page<MovementDTO> movementDtoPage = movementFacade.getAll(page);

        return ResponseEntity.ok(movementMapper.toMovementResponseModelPage(movementDtoPage));
    }

    @PostMapping
    public ResponseEntity<MovementResponseModel> create(@RequestBody @Valid MovementRequestModel requestModel) {
        MovementRequestDTO dto = movementMapper.toMovementRequestDTO(requestModel);
        MovementDTO movementDto = movementFacade.createMovement(dto);
        return ResponseEntity.ok(movementMapper.toMovementResponseModel(movementDto));
    }
}
