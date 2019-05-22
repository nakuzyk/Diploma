package com.epam.repository.impl;

import com.epam.dto.ProductDto;
import com.epam.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<ProductDto> {

    public List<ProductDto> getRepositoryItems() {
        List<ProductDto> productsDto = new ArrayList<ProductDto>() {
            {
                add(new ProductDto("1", "Bag", "CHANEL", 1));
                add(new ProductDto("2", "Pen", "Olympio", 4));
                add(new ProductDto("3", "Spinner", "BONITOYS", 2));
            }
        };
        return productsDto;
    }
}