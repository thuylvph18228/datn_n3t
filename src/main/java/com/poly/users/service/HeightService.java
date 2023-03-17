package com.poly.users.service;

import com.poly.users.entity.Height;

import java.util.List;

public interface HeightService {
    List<Height> getAll();
    Height getById(int HeightId);
    Height save(Height height);
    Height update(Height height);
    void delete(int id);
}
