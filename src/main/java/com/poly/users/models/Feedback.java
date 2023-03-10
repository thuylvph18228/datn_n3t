package com.poly.users.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fb_id")
    private Integer fbID;

    @Column(name = "rating_type")
    private int ratingType;

    private String describe;
}
