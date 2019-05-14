package com.epam.controllers.impl;

import com.epam.controllers.ProductController;
import com.epam.dao.ProductDao;
import com.epam.dao.impl.DefaultProductDao;
import com.epam.model.ProductModel;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultProductController implements ProductController {
    ProductDao productDao;

    public DefaultProductController(DefaultProductDao defaultProductDao) {
        productDao = defaultProductDao;
    }

    @Override
    public void setProductDao() {
        productDao = new DefaultProductDao();
    }

    @Override
    public List getProducts() {
        return productDao.getProducts();
    }

    @Override
    public List getAvailableProducts() {
        return productDao.getProducts()
                .stream()
                .filter(m -> m.getQuantity() > 0)
                .map(ProductModel::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List getProductsWithPromotions() {
        return productDao.getProducts()
                .stream()
                .filter(productModel -> !productModel.getPromotionModelList().isEmpty())
                .map(ProductModel::getName)
                .collect(Collectors.toList());
    }
}