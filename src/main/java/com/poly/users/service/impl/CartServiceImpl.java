package com.poly.users.service.impl;

import com.poly.users.models.Cart;
import com.poly.users.models.Products;
import com.poly.users.repositories.CartRepository;
import com.poly.users.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public Cart create(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Integer id) {
        cartRepository.deleteById(id);
    }

    private Map<String, Products> items = new HashMap<>();

    public void addItem(Products product) {
//        if (items.containsKey(product.getProdID())) {
//            Products item = items.get(product.getProdID());
//        } else {
            Products item = new Products();
            items.put(item.getProdID(), item);
//        }
    }

    public void removeItem(String itemId) {
        items.remove(itemId);
    }

    public List<Products> getItems() {
        return new ArrayList<>(items.values());
    }

    public double getTotal() {
        double total = 0.0;
//        for (Products item : items.values()) {
//            total += item.getPrice() * item.getQuantity();
//        }
        return total;
    }

    public int getItemCount() {
        int count = 0;
//        for (Products item : items.values()) {
//            count += item.getQuantity();
//        }
        return count;
    }
}
