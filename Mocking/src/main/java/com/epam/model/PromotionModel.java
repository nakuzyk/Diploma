package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PromotionModel {
    private String idPromotion;
    private String promotionMessage;
}