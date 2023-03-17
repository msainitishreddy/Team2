package com.ecommerce.prorunner.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cart")
@Setter
@Getter
@RequiredArgsConstructor
public class CartEntity {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cartEntity",cascade = CascadeType.ALL)
    private ProRunnerUserEntity proRunnerUserEntity;

    @OneToMany(mappedBy="cartEntity")
    private List<ProductEntity> productEntityList;
}
