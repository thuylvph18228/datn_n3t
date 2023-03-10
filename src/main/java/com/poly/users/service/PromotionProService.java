package com.poly.users.service;

import com.poly.users.models.PromotionProduct;

import java.util.List;

public interface PromotionProService {
    public List<PromotionProduct> findAll();

    public PromotionProduct findById(Integer id) ;

    public PromotionProduct create(PromotionProduct product) ;

    public PromotionProduct update(PromotionProduct product) ;
}
