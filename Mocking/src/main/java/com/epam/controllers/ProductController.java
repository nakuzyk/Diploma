package com.epam.controllers;

import com.epam.dao.ProductDao;

import java.util.List;

public interface ProductController<T> {
    void setProductDao(ProductDao productDao);

    List<T> getProducts();

    List<T> getAvailableProducts();

    List<T> getProductsWithPromotions();
}