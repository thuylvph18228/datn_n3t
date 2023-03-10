package com.poly.users.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private Integer imgID;

    @Column(name = "alt_text")
    private String altText;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "updated_at")
    private String updateAt;

    @Column(name = "created_at")
    private String createAt;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Products products;
}
