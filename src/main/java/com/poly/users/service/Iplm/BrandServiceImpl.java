package com.poly.users.service.Iplm;

import com.poly.users.DTO.BrandDto;
import com.poly.users.entity.Brand;
import com.poly.users.repository.BrandRepository;
import com.poly.users.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepo;

    @Override
    @Transactional
    public List<Brand> getAll() {
        return this.brandRepo.findAll();
    }

    @Override
    @Transactional
    public Brand getById(int brandId) {
        return this.brandRepo.findById(brandId).get();
    }

    @Override
    @Transactional
    public Brand save(Brand brand) {
        return null;
    }

    @Override
    @Transactional
    public Brand update(Brand brand) {
        return null;
    }

    @Override
    @Transactional
    public Brand delete(int id) {
        this.brandRepo.deleteById(id);
        return null;
    }

    @Override
    public BrandDto save(BrandDto brandDto) {
        BrandDto b = this.brandRepo.saveAndFlush(Brand.toEntity(brandDto)).toDto();
        return b;

    }

}
