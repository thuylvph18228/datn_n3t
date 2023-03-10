package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_dtl_id")
    private Integer proDtlId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "listed_price")
    private String listedPrice;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @CreationTimestamp
    protected LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Products products;
}
