package com.farouishop.productService.services;

import com.farouishop.productService.dtos.ProductRequest;
import com.farouishop.productService.dtos.ProductResponse;
import com.farouishop.productService.entities.Product;
import com.farouishop.productService.exceptions.ProductNotFoundException;
import com.farouishop.productService.mappers.ProductMapper;
import com.farouishop.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductRequest productRequest) {
        Product product = productMapper.fromProductRequestToProduct(productRequest);
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    @Override
    public ProductResponse getProductsById(String id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return productMapper.fromProductToProductResponse(product.get());
        } else {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::fromProductToProductResponse)
                .collect(Collectors.toList());
    }
}
