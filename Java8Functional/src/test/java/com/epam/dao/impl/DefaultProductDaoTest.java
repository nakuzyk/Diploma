package com.epam.dao.impl;

import com.epam.model.ProductModel;
import com.epam.repository.impl.ProductRepository;
import com.epam.repository.impl.PromotionRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


public class DefaultProductDaoTest {

    ProductRepository productRepository = new ProductRepository();
    PromotionRepository promotionRepository = new PromotionRepository();
    DefaultProductDao productDao = new DefaultProductDao();

    @Before
    public void setUp() throws Exception {
        productRepository = new ProductRepository();
        promotionRepository = new PromotionRepository();
        productDao = new DefaultProductDao();
        productDao.setProductRepository(productRepository);
        productDao.setPromotionRepository(promotionRepository);
    }

    @Test
    public void checkListIsNotEmpty() {
        List<ProductModel> productModels = productDao.getProducts()
                .stream()
                .filter(promotion -> !promotion.getPromotionModelList().isEmpty())
                .collect(Collectors.toList());
        Assert.assertNotNull(productModels);
    }

    @Test
    public void checkListIsCorrectData() {
        List<ProductModel> productModels = productDao.getProducts().stream()
                .filter(prom -> prom.getPromotionModelList().isEmpty())
                .collect(Collectors.toList());
        Assert.assertEquals(productModels.stream().findAny().map(p -> p.getIDProduct()).toString(), "Optional[1]");
        Assert.assertEquals(productModels.stream().findFirst().map(s -> s.getName()).toString(), "Optional[Bag]");
        Assert.assertEquals(productModels.stream().findFirst().map(s -> s.getBrand()).toString(), "Optional[CHANEL]");
        Assert.assertEquals(productModels.stream().findAny().map(p -> p.getQuantity()).toString(), "Optional[1]");
    }
}