package com.poly.users.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private Integer addID;

    private String address;

    private String district;

    private String provice;

    private String city;

    private String ward;

    private String name;

    private int phone;

    private boolean defaultt;

    @ManyToOne
    @JoinColumn(name = "acc_id")
    private Account account;
}
