package com.poly.users.service.Iplm;

import com.poly.users.DTO.ShopDto;
import com.poly.users.entity.Shop;
import com.poly.users.repository.ShopRepository;
import com.poly.users.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepo;

    @Override
    public ShopDto get() {
        return shopRepo.findAll().get(0).toDto();
    }

    @Override
    public ShopDto save(ShopDto shopDto) {
        return this.shopRepo.save(Shop.toEntity(shopDto)).toDto();
    }
}
