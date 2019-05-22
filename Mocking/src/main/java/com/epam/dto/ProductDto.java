package com.epam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDto {
    private String idProduct;
    private String name;
    private String brand;
    private int quantity;
}