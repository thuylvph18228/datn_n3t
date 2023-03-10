package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "origin")
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Integer orgID;

    private String country;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @CreationTimestamp
    protected LocalDateTime updateAt;

    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private List<Products> products;
}
