package com.gt_enterprise.product_catalog_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gt_enterprise.product_catalog_service.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
