package com.gt_enterprise.product_catalog_service.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gt_enterprise.product_catalog_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll(Specification<Product> specification);
}
