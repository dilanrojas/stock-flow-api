package com.stockflow.stockflow_backend.models.MovementModels;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record MovementRequestModel(
    @NotNull(message = "Stock resource ID is required") UUID stockResourceId,
    @NotNull(message = "Quantity is required") Integer quantity,
    String note
) {
}
