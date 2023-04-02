package com.ecommerce.prorunner.repository;

import com.ecommerce.prorunner.entity.ProRunnerUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProRunnerRepository extends JpaRepository<ProRunnerUserEntity,Long> {
    ProRunnerUserEntity findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ProRunnerUserEntity pru SET pru.cartProductList = :productIds where pru.id =:proRunnerId")
    void addOrUpdateProductsToCartList(@Param("productIds") String productIds, @Param("proRunnerId") Long proRunnerId);

    @Query(value = "SELECT cartProductList FROM ProRunnerUserEntity pru where pru.id =:proRunnerId")
    String getCartListProducts(@Param("proRunnerId") Long proRunnerId);
}
