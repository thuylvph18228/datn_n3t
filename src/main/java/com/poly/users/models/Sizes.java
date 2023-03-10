package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "sizes")
public class Sizes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sz_id")
    private Integer szID;

    @Column(name = "name_sz")
    private String nameSz;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Products products;
}
