package com.epam.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductModel {
    @NonNull
    private String iDProduct;
    @NonNull
    private String name;
    @NonNull
    private String brand;
    @NonNull
    private int quantity;
    private List<PromotionModel> promotionModelList;
}