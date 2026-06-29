package com.lns.inventory.service;

import com.lns.inventory.dto.ProductRequestDTO;
import com.lns.inventory.dto.ProductResponseDTO;
import com.lns.inventory.entity.Product;
import com.lns.inventory.exception.ProductNotFoundException;
import com.lns.inventory.mapper.ProductMapper;
import com.lns.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toResponseDTO(savedProduct);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}