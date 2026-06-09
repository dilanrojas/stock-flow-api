package com.stockflow.stockflow_backend.models.MovementModels;

import java.time.LocalDateTime;
import java.util.UUID;

public record MovementResponseModel(
    Integer quantity,
    String note,
    LocalDateTime createdAt,
    UUID resourceId,
    UUID stockResourceId
) {
}
