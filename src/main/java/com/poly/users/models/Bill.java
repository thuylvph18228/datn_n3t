package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billID;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdDate;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "price_after_voucher")
    private Double priceAfterVoucher;

    private String address;

    @Column(name = "ship_price")
    private Double shipPrice;

    @UpdateTimestamp
    protected LocalDateTime updatedDate;

    @Column(name = "receiver_name")
    private Double receiverName;

    private String email;

    private String district;

    private String provice;

    private String city;

    private String name;

    private String ward;

    private int phone;

    private String note;

//    @Column(name = "birthdate")
//    private LocalDateTime birthDate;

    @ManyToOne
    @JoinColumn(name = "acc_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "vc_id")
    private Vouchers vouchers;
//
//    @ManyToOne
//    @JoinColumn(name = "acc_id")
//    private Pay pay;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillProduct> billProducts;
}
