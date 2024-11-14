package com.gt_enterprise.product_catalog_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gt_enterprise.product_catalog_service.entity.Product;
import com.gt_enterprise.product_catalog_service.repository.ProductRepository;
import com.gt_enterprise.product_catalog_service.specification.ProductSpecification;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(Long categoryId, Double minPrice, Double maxPrice, Integer minStock,
            Boolean isActive) {
        Specification<Product> specification = Specification.where(null);
        if (categoryId != null) {
            specification = specification.and(ProductSpecification.hasCategory(categoryId));
        }
        if (minPrice != null && maxPrice != null) {
            specification = specification.and(ProductSpecification.hasPriceBetween(minPrice, maxPrice));
        }
        if (minStock != null) {
            specification = specification.and(ProductSpecification.hasStockGreaterThan(minStock));
        }
        if (isActive != null) {
            specification = specification.and(ProductSpecification.isActive());
        }
        return productRepository.findAll(specification);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
