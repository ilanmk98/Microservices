package com.imikler.productservice.service;

import com.imikler.productservice.dto.ProductDTO;
import com.imikler.productservice.model.Product;
import com.imikler.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductDTO productRequest)
    {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} has been saved",product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
