package com.poly.users.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "voucher_account")
public class VoucherAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vcacc_id")
    private Integer vcAccId;

    private String status;

    @ManyToOne
    @JoinColumn(name = "acc_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "vc_id")
    private Vouchers vouchers;
}
