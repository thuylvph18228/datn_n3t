package com.poly.users.service;

import com.poly.users.DTO.BrandDto;
import com.poly.users.entity.Brand;

import java.util.List;


public interface BrandService {

    List<Brand> getAll();
    Brand getById(int brandId);
    Brand save(Brand brand);
    Brand update(Brand brand);
    Brand delete(int id);

    BrandDto save(BrandDto brandDto);
}
