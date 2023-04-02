package com.ecommerce.prorunner.repository;

import com.ecommerce.prorunner.entity.OrderEntity;
import com.ecommerce.prorunner.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

}