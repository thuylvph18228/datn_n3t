package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "promotion_product")
public class PromotionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_prod_id")
    private Integer proCateId;

    private String name;

    private Double percentage;

    private String description;

    private String status;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @CreationTimestamp
    protected LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Products products;
}
