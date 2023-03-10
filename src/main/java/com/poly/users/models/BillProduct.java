package com.poly.users.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bill_product")
public class BillProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_prod_id")
    private Integer billProId;

    private Double amount;

    private Double price;

    private int quantity;
}
