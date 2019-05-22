package com.epam.dao;

import com.epam.dto.ProductDto;
import com.epam.dto.PromotionDto;
import com.epam.model.ProductModel;
import com.epam.repository.Repository;

import java.util.List;

public interface ProductDao {
    void setProductRepository(Repository<ProductDto> productDtoRepository);

    void setPromotionRepository(Repository<PromotionDto> promotionDtoRepository);

    List<ProductModel> getProducts();
}