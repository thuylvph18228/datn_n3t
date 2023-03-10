package com.poly.users.service;

import com.poly.users.models.PromotionCategory;

import java.util.List;

public interface PromotionCateService {
    public List<PromotionCategory> findAll();

    public PromotionCategory findById(Integer id) ;

    public PromotionCategory create(PromotionCategory product) ;

    public PromotionCategory update(PromotionCategory product) ;
}
