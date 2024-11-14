package com.gt_enterprise.product_catalog_service.specification;

import org.springframework.data.jpa.domain.Specification;

import com.gt_enterprise.product_catalog_service.entity.Product;

public class ProductSpecification {
    public static Specification<Product> hasCategory(Long categoryId) {
        return (root, query, builder) -> builder.equal(root.get("category").get("id"), categoryId);
    }

    public static Specification<Product> hasPriceBetween(Double minPrice, Double maxPrice) {
        return (root, query, builder) -> builder.between(root.get("price"), minPrice, maxPrice);
    }

    public static Specification<Product> hasStockGreaterThan(Integer minStock) {
        return (root, query, builder) -> builder.greaterThan(root.get("stock"), minStock);
    }

    public static Specification<Product> isActive() {
        return (root, query, builder) -> builder.isTrue(root.get("isActive"));
    }
}
