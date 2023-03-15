package com.poly.users.repositories;

import com.poly.users.models.PromotionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionCateRepository extends JpaRepository<PromotionCategory, Integer> {
}
