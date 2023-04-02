package com.ecommerce.prorunner.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name="product")
@Setter
@Getter
@RequiredArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private Float price;

    private String category;

    private String categoryType;

    @Lob
    @Column
    private String image;

    @Transient
    private MultipartFile file;

    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_order",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private OrderEntity orderEntity;//done--fixed

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_cart",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "cart_id") }
    )
    private CartEntity cartEntity;*/

}
