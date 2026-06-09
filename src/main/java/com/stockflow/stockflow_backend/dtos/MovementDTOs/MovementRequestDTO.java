package com.stockflow.stockflow_backend.dtos.MovementDTOs;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementRequestDTO {
    private UUID stockResourceId;
    private Integer quantity;
    private String note;
}
