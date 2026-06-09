package com.stockflow.stockflow_backend.dtos.MovementDTOs;

import java.time.LocalDateTime;
import java.util.UUID;

public record MovementDTO(
    Integer quantity,
    String note,
    LocalDateTime createdAt,
    UUID resourceId,
    UUID stockResourceId
) {
}
