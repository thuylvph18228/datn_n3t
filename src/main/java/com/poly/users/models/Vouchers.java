package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vouchers")
public class Vouchers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vc_id")
    private Integer vcID;

    private String note;

    private int status;

    private Double discount;

    @Column(name = "voucher_name")
    private String voucherName;

    @Column(name = "voucher_code")
    private String voucherCode;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    private String type;

    @Column(name = "point_to_receiver")
    private String pointToReceiver;

    @Column(name = "payment_type")
    private String paymentType;

    private Double amount;

    @CreationTimestamp
    protected LocalDateTime fromTime;

    @UpdateTimestamp
    protected LocalDateTime toTime;
}
