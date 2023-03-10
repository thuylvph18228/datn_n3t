package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id")
    private Integer accID;

    @Column(name = "username")
    private String userName;

    @Column(name = "fullname")
    private String fullName;

    private String password;

    private String email;

    private int phone;

    private String gender;

    @Column(name = "birthdate")
    private LocalDateTime birthDate;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<VoucherAccount> vcAccount;
}
