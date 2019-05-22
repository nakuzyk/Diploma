package com.epam.controllers;

import com.epam.controllers.impl.DefaultProductController;
import com.epam.dao.ProductDao;
import com.epam.model.ProductModel;
import com.epam.model.PromotionModel;
import org.mockito.Mockito;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductControllerTests {
    private List<ProductModel> productModelList;
    private ProductDao productDao;
    private ProductController productController;

    @BeforeGroups(groups = {"regression", "smoke"})
    public void setUp() {
        productModelList = new ArrayList<>();
        productModelList.add(ProductModel
                .builder()
                .iDProduct("1")
                .name("Bag")
                .brand("CHANEL")
                .quantity(1)
                .promotionModelList(new ArrayList<>())
                .build());
        List<PromotionModel> expectedPromotionModels = new ArrayList<>();
        expectedPromotionModels.add(PromotionModel
                .builder()
                .idPromotion("2")
                .promotionMessage("Dress")
                .build());
        productModelList.add(ProductModel
                .builder()
                .iDProduct("2")
                .name("Pen")
                .brand("Olympio")
                .quantity(4)
                .promotionModelList(expectedPromotionModels)
                .build());
        productModelList.add(ProductModel
                .builder()
                .iDProduct("3")
                .name("Spinner")
                .brand("BONITOYS")
                .quantity(2)
                .promotionModelList(expectedPromotionModels)
                .build());
        productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.getProducts()).thenReturn(productModelList);

        productController = new DefaultProductController();
        productController.setProductDao(productDao);
    }

    @Test(groups = "smoke")
    public void getProductsTest() {
        assertThat(productController.getProducts())
                .as("ProductController must return valid ProductModels")
                .containsAll(productModelList);
    }

    @Test(groups = "regression")
    public void getAvailableProductsTest() {
        List<ProductModel> expectedProducts = new ArrayList<>(productModelList);
        expectedProducts.remove(0);
        assertThat(productController.getProducts())
                .as("ProductController must return valid only available products")
                .containsAll(expectedProducts);
    }

    @Test(groups = "regression")
    public void getProductWithDiscountTest() {
        List<ProductModel> expectedProducts = new ArrayList<>(productModelList);
        expectedProducts.remove(2);
        expectedProducts.remove(0);
        assertThat(productController.getProductsWithPromotions())
                .as("ProductController must return only products with discount")
                .containsAll(expectedProducts);
    }
}