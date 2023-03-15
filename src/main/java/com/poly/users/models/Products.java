package com.poly.users.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private String prodID;

    @Column(name = "name_prod")
    private String nameProd;

    private String status;
    private String gender;
//    private int price;

    @Column(name = "total_amount")
    private String totalAmount;

//    @Column(name = "listed_price")
//    private String listedPrice;

    private String available;

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Origin origin;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brd_id")
    private Brand brand;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Colors> colors;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<PromotionProduct> promotionProducts;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<Sizes> sizes;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<BillProduct> billProducts;
}
