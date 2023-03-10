package com.poly.users.service;

import com.poly.users.models.Feedback;

import java.util.List;

public interface FeedbackService {
    public List<Feedback> findAll();

    public Feedback findById(Integer id) ;

    public Feedback create(Feedback product) ;

    public Feedback update(Feedback product) ;
}
