package com.ecommerce.prorunner.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="prorunner_user")
@Setter
@Getter
@RequiredArgsConstructor
public class ProRunnerUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String password;

    private String role;

    /*@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "product-prorunner-user",
            joinColumns = { @JoinColumn(name = "pro_runner_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private Set<ProductEntity> products;*/

    @OneToMany(mappedBy = "proRunnerUser")
    private List<OrderEntity> orderList;//fixed

    @OneToOne
   /* @MapsId*/
    @JoinTable(
            name = "user_cart",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "cart_id") }
    )
    private CartEntity cartEntity;

    /*@OneToOne(cascade = CascadeType.ALL,mappedBy = "productEntityList")
    private CartEntity cartEntity;*/
}
