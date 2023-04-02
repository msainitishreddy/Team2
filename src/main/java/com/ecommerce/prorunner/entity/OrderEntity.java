package com.ecommerce.prorunner.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
@Setter
@Getter
@RequiredArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String address;

    @OneToMany(mappedBy="orderEntity")
    private List<ProductEntity> products;//done--fixed

    @ManyToOne
    @JoinColumn(name="prorunner_user_id", nullable=false)
    private ProRunnerUserEntity proRunnerUser;//fixed
}
