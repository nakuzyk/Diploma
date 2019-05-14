package com.epam.repository.impl;

import com.epam.dto.PromotionDto;
import com.epam.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class PromotionRepository implements Repository<PromotionDto> {
    public List<PromotionDto> getRepositoryItems() {
        List<PromotionDto> promotionsDto = new ArrayList<PromotionDto>();
        promotionsDto.add(new PromotionDto("1", "Shoes", "10"));
        promotionsDto.add(new PromotionDto("2", "Dress", "100"));
        return promotionsDto;
    }
}