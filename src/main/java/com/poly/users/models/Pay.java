package com.poly.users.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pay_id")
    private Integer payID;

    @Column(name = "name_pay")
    private String namePay;
}
