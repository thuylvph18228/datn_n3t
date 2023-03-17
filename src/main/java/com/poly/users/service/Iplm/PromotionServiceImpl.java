package com.poly.users.service.Iplm;

import com.poly.users.DTO.PromotionDto;
import com.poly.users.entity.Promotion;
import com.poly.users.repository.PromotionRepository;
import com.poly.users.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepo;

    @Override
    @Transactional
    public List<PromotionDto> getAll() {
        return this.promotionRepo.findAll().stream().map(Promotion :: toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<PromotionDto> getAllByStatus(String status) {
        return null;
    }

    @Override
    @Transactional
    public List<Promotion> getAllByDate(String date) {
        return null;
    }

    @Override
    @Transactional
    public PromotionDto getById(int PromotionId) {
        return null;
    }

    @Override
    @Transactional
    public PromotionDto save(PromotionDto promotionDto) {
        return this.promotionRepo.save(Promotion.toEntity(promotionDto)).toDto();
    }

    @Override
    @Transactional
    public Promotion delete(int id) {
        return null;
    }
}
