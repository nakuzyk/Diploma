package com.epam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PromotionDto {
    private String idPromotion;
    private String promotionMessage;
    private String applicableProductId;
}