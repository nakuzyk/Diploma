package com.epam.repository.impl;

import com.epam.controllers.impl.DefaultProductController;
import com.epam.dao.impl.DefaultProductDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CachedProductRepositoryTest {

    DefaultProductController defaultProductController;

    @Before
    public void setUp() throws Exception {

        ProductRepository productRepository = new ProductRepository();
        PromotionRepository promotionRepository = new PromotionRepository();
        DefaultProductDao defaultProductDao = new DefaultProductDao();
        CachedProductRepository cachedProductRepository = new CachedProductRepository(productRepository);
        defaultProductDao.setProductRepository(cachedProductRepository);
        defaultProductDao.setPromotionRepository(promotionRepository);
        defaultProductController = new DefaultProductController(defaultProductDao);
    }

    @Test
    public void getRepositoryItems() {
        Assert.assertNotNull(defaultProductController.getProducts());
    }
}