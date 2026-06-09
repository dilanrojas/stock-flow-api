package com.stockflow.stockflow_backend.models.PurchaseModels;

import java.time.LocalDate;
import java.util.List;

import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailRequestModel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PurchaseRequestModel(
    @NotNull(message = "Date field is required") LocalDate date,
    @NotBlank(message = "Reason field is required") String reason,
    @NotEmpty(message = "Purchase details list cannot be empty") @Valid List<PurchaseDetailRequestModel> purchaseDetails

    
) {
    
}