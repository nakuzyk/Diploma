package com.epam.dao;

import com.epam.dto.ProductDto;
import com.epam.dto.PromotionDto;
import com.epam.model.ProductModel;
import com.epam.model.PromotionModel;
import com.epam.repository.Repository;
import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultProductDao implements ProductDao {
    private Repository<ProductDto> productRepository;
    static private Repository<PromotionDto> promotionRepository;

    public void setProductRepository(Repository<ProductDto> productDtoRepository) {
        productRepository = productDtoRepository;
    }

    public void setPromotionRepository(Repository<PromotionDto> promotionDtoRepository) {
        promotionRepository = promotionDtoRepository;
    }

    public List<ProductModel> getProducts() {
        return Try.of(() -> productRepository.getRepositoryItems()
                .stream()
                .map(product -> new ProductModel(product.getIdProduct(), product.getName(), product.getBrand(), product.getQuantity()))
                .peek(productModel -> productModel.setPromotionModelList(getPromotionModelList(productModel)))
                .collect(Collectors.toList())).getOrElse(new ArrayList<>());
    }

    static private List<PromotionModel> getPromotionModelList(ProductModel productModel) {
        return Try.of(() -> promotionRepository.getRepositoryItems()
                .stream()
                .filter(r -> r.getApplicableProductId().equals(productModel.getIDProduct()))
                .map(promotion -> new PromotionModel(promotion.getIdPromotion(), promotion.getPromotionMessage()))
                .collect(Collectors.toList())).getOrElse(new ArrayList<>());
    }
}