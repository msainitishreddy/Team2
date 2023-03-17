package com.ecommerce.prorunner.repository;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import com.ecommerce.prorunner.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    ProductEntity save(ProductEntity productEntity);
    void save(Long id);
}
