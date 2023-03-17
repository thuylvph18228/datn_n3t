package com.poly.users.service.Iplm;

import com.poly.users.entity.PromotionBlacklist;
import com.poly.users.service.PromotionBlackListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PromotionBlackListServiceImpl implements PromotionBlackListService {
    @Override
    @Transactional
    public List<PromotionBlacklist> getAll() {
        return null;
    }

    @Override
    @Transactional
    public List<PromotionBlacklist> getAllByPromotionId(int PromotionId) {
        return null;
    }

    @Override
    @Transactional
    public PromotionBlacklist getById(int PromotionBlacklistId) {
        return null;
    }

    @Override
    @Transactional
    public PromotionBlacklist save(PromotionBlacklist promotionBlacklist) {
        return null;
    }

    @Override
    @Transactional
    public PromotionBlacklist update(PromotionBlacklist promotionBlacklist) {
        return null;
    }

    @Override
    @Transactional
    public PromotionBlacklist delete(int id) {
        return null;
    }
}
