package com.poly.users.service;

import com.poly.users.models.Cart;
import com.poly.users.models.Cart;
import com.poly.users.models.Products;

import java.util.List;

public interface CartService {
    public List<Cart> findAll();

    public Cart findById(Integer id) ;

    public Cart create(Cart product) ;

    public Cart update(Cart product) ;

    public void delete(Integer id) ;

    public void addItem(Products product);

    public void removeItem(String itemId);

    public List<Products> getItems();

    public double getTotal();

    public int getItemCount();
}
