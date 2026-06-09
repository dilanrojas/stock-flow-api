package com.stockflow.stockflow_backend.mappers;

import java.util.List;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailRequestModel;
import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailResponseModel;

@Component
public class PurchaseDetailMapper {

    public PurchaseDetailDTO toPurchaseDetailDTO(PurchaseDetail purchaseDetail) {
        if (purchaseDetail == null){
             return null;
        }

        
        return new PurchaseDetailDTO(purchaseDetail.getResourceId(), purchaseDetail.getStock().getProduct().getName(), purchaseDetail.getStock().getProduct().getImageURL(),  purchaseDetail.getQuantity(), purchaseDetail.getUnitPrice(), purchaseDetail.getSubtotal());
    }

    public List<PurchaseDetailDTO> toPurchaseDetailDTOList(List<PurchaseDetail> purchaseDetails) {
        if (purchaseDetails == null){
             return null;
        }
        return purchaseDetails.stream()
            .map(this::toPurchaseDetailDTO)
            .toList();
    }

    public PurchaseDetailResponseModel toPurchaseDetailResponseModel(PurchaseDetailDTO purchaseDetailDTO) {
        if (purchaseDetailDTO == null){
            return null;
        }


        return new PurchaseDetailResponseModel(purchaseDetailDTO.resourceId(), purchaseDetailDTO.productName(), purchaseDetailDTO.imageURL(), purchaseDetailDTO.quantity(), purchaseDetailDTO.unitPrice(), purchaseDetailDTO.subtotal());
    }

    public List<PurchaseDetailResponseModel> toPurchaseDetailResponseModelList(List<PurchaseDetailDTO> purchaseDetailDTOList) {
        if (purchaseDetailDTOList == null){
            return null;
        }
        return purchaseDetailDTOList.stream()
            .map(this::toPurchaseDetailResponseModel)
            .toList();
    }

    public PurchaseDetailRequestDTO toPurchaseDetailRequestDTO(PurchaseDetailRequestModel purchaseDetailRequestModel) {
        if (purchaseDetailRequestModel == null){
            return null;
        }

        PurchaseDetailRequestDTO dto = new PurchaseDetailRequestDTO();
        dto.setStockResourceId(purchaseDetailRequestModel.stockResourceId());
        dto.setQuantity(purchaseDetailRequestModel.quantity());
        return dto;
    }


    public List<PurchaseDetailRequestDTO> toPurchaseDetailRequestDTOList(List<PurchaseDetailRequestModel> purchaseDetailRequestModelList) {
        if (purchaseDetailRequestModelList == null){
            return null;
        }
        return purchaseDetailRequestModelList.stream()
            .map(this::toPurchaseDetailRequestDTO)
            .toList();
    }
}