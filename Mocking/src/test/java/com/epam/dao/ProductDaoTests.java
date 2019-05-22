package com.epam.dao;

import com.epam.dto.ProductDto;
import com.epam.dto.PromotionDto;
import com.epam.repository.impl.ProductRepository;
import com.epam.repository.impl.PromotionRepository;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoTests {

    private DefaultProductDao defaultProductDao = new DefaultProductDao();

    @Test(groups = "smoke")
    public void verifyProductsWithPromotionIsPresent() throws IOException {
        final List<ProductDto> productDtos = new ArrayList<ProductDto>() {
            {
                add(new ProductDto("1", "Bag", "CHANEL", 1));
                add(new ProductDto("2", "Pen", "Olympio", 4));
                add(new ProductDto("3", "Spinner", "BONITOYS", 2));
            }
        };
        final List<PromotionDto> promotionDtos = new ArrayList<PromotionDto>();
        promotionDtos.add(new PromotionDto("1", "Shoes", "10"));
        promotionDtos.add(new PromotionDto("2", "Dress", "100"));

        ProductRepository productRepository = Mockito.mock(ProductRepository.class);
        PromotionRepository promotionRepository = Mockito.mock(PromotionRepository.class);

        defaultProductDao.setProductRepository(productRepository);
        defaultProductDao.setPromotionRepository(promotionRepository);

        Mockito.when(productRepository.getRepositoryItems()).thenReturn(productDtos);
        Mockito.when(promotionRepository.getRepositoryItems()).thenReturn(promotionDtos);

        defaultProductDao.getProducts();
        Mockito.verify(productRepository, Mockito.atMost(10)).getRepositoryItems();
        Mockito.verify(promotionRepository, Mockito.atMost(10)).getRepositoryItems();
    }
}