package com.stockflow.stockflow_backend.dtos.PurchaseDTOs;

import java.time.LocalDate;
import java.util.List;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;

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

public class PurchaseRequestDTO {
    private LocalDate date;
    private String reason;
    private List<PurchaseDetailRequestDTO> purchaseDetails;
}