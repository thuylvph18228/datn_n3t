package com.poly.users.service;

import com.poly.users.models.Address;

import java.util.List;

public interface AddressService {
    public List<Address> findAll();

    public Address findById(Integer id) ;

    public Address create(Address product) ;

    public Address update(Address product) ;
}
