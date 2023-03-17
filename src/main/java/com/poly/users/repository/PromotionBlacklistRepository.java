package com.poly.users.repository;

import com.poly.users.entity.PromotionBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionBlacklistRepository extends JpaRepository<PromotionBlacklist, Integer> {
}