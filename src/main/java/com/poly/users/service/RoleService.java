package com.poly.users.service;

import com.poly.users.models.Roles;
import com.poly.users.models.Products;

import java.util.List;

public interface RoleService {
    public List<Roles> findAll();

    public Roles findById(Integer id) ;

    public Roles create(Roles product) ;

    public Roles update(Roles product) ;
}
