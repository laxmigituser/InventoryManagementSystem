package com.lns.inventory.mapper;

import com.lns.inventory.dto.ProductRequestDTO;
import com.lns.inventory.dto.ProductResponseDTO;
import com.lns.inventory.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        return product;
    }

    public static ProductResponseDTO toResponseDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());

        return dto;
    }
}