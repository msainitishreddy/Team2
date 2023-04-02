package com.ecommerce.prorunner.repository;

import com.ecommerce.prorunner.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    @Query("SELECT pe FROM ProductEntity pe where pe.id in :productIds")
    List<ProductEntity> listOfProductsByIds(@Param("productIds") List<Long> productIds);

    @Query("SELECT pe FROM ProductEntity pe where lower(pe.category) = lower(:category) and lower(pe.categoryType) = lower(:categoryType)")
    List<ProductEntity> getProductsByCategoryAndSubCategory(@Param("category") String category, @Param("categoryType") String categoryType);

    @Query("SELECT pe FROM ProductEntity pe where lower(pe.category) = lower(:category)")
    List<ProductEntity> getProductsByCategory(@Param("category") String category);

}
