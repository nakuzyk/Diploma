package com.epam.controllers;

import java.util.List;

public interface ProductController<T> {
    void setProductDao();

    List<T> getProducts();

    List<T> getAvailableProducts();

    List<T> getProductsWithPromotions();
}