package com.stockflow.stockflow_backend.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.dtos.StockDTOs.StockDTO;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;
import com.stockflow.stockflow_backend.models.StockModels.StockResponseModel;

@Component
public class StockMapper {

    @Autowired
    private ProductMapper productMapper;

    public StockDTO toStockDTO(Stock stock){
        if (stock == null) {
            return null;
        }

        ProductDTO productDTO = productMapper.toProductDto(stock.getProduct());

        return new StockDTO(stock.getQuantity(),stock.getMinimumQuantity(), stock.getResourceId(), productDTO);
        
    }


    public Page<StockDTO> toStockDTOPage(Page<Stock> stockPage){

        if (stockPage == null) {
            return null;
        }

        return stockPage.map(this::toStockDTO);
    }



    public StockResponseModel toStockResponseModel(StockDTO stockDTO){
        if (stockDTO == null) {
            return null;
        }

        ProductResponseModel productResponseModel = productMapper.toProductResponseModel(stockDTO.productDTO());

        return new StockResponseModel(stockDTO.quantity(),stockDTO.minimumQuantity(),stockDTO.resourceId(), productResponseModel);

    }




    public Page<StockResponseModel> toStockResponseModelPage(Page<StockDTO> stockDTOPage){
        if (stockDTOPage == null) {
            return null;
        }

        return stockDTOPage.map(this::toStockResponseModel);

    }
    
}
