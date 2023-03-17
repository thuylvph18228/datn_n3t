package com.poly.users.service;

import com.poly.users.DTO.ShopDto;

public interface ShopService {
    ShopDto get();
    ShopDto save(ShopDto shopDto);
}
