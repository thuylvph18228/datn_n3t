package com.poly.users.repository;

import com.poly.users.entity.PromotionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionCategoryRepository extends JpaRepository<PromotionCategory, Integer> {
}