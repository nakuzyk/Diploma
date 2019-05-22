package com.epam.repository.impl;

import com.epam.dto.ProductDto;
import com.epam.repository.Repository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Log4j
@RequiredArgsConstructor
public class CachedProductRepository implements Repository {
    @NonNull
    private ProductRepository productRepository;
    private Optional<List<ProductDto>> optionalProductDtos;


    @Override
    public List<ProductDto> getRepositoryItems() throws IOException {
        if (optionalProductDtos.isPresent()) {
            log.info("Data product was cached");
            return optionalProductDtos.get();
        } else {
            optionalProductDtos = Optional.of(productRepository.getRepositoryItems());
            log.info("Data product was not cached");
            return optionalProductDtos.get();
        }
    }
}