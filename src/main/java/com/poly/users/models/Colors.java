package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "colors")
public class Colors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Integer colorID;

    @Column(name = "name_color")
    private String nameColor;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Products products;
}
