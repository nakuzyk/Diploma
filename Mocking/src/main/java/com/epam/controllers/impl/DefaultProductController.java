package com.epam.controllers.impl;

import com.epam.controllers.ProductController;
import com.epam.dao.ProductDao;
import com.epam.model.ProductModel;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultProductController implements ProductController {
    private ProductDao productDao;

    @Override
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List getProducts() {
        return productDao.getProducts();
    }

    @Override
    public List<ProductModel> getAvailableProducts() {
        return productDao.getProducts()
                .stream()
                .filter(m -> m.getQuantity() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductModel> getProductsWithPromotions() {
        return productDao.getProducts()
                .stream()
                .filter(productModel -> !productModel.getPromotionModelList().isEmpty())
                .collect(Collectors.toList());
    }
}