package com.poly.users.service;

import com.poly.users.models.Image;

import java.util.List;

public interface ImageService {
    public List<Image> findAll();

    public Image findById(Integer id) ;

    public Image create(Image product) ;

    public Image update(Image product) ;
}
