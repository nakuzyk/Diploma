package com.epam;

import com.epam.dao.impl.DefaultProductDao;
import com.epam.model.ProductModel;
import com.epam.repository.impl.ProductRepository;
import com.epam.repository.impl.PromotionRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new ProductRepository();
        PromotionRepository promotionRepository = new PromotionRepository();
        DefaultProductDao productDao = new DefaultProductDao();
        productDao.setProductRepository(productRepository);
        productDao.setPromotionRepository(promotionRepository);

        List<ProductModel> products = productDao.getProducts()
                .stream()
                .filter(promotion -> !promotion.getPromotionModelList().isEmpty())
                .collect(Collectors.toList());

        productDao.getProducts()
                .stream()
                .filter(promotion -> !promotion.getPromotionModelList().isEmpty())
                .forEach(c -> System.out.println(c.getIDProduct() + " " + c.getName() + " " + c.getQuantity() + " " + c.getBrand() + " " + c.getPromotionModelList()));
    }
}