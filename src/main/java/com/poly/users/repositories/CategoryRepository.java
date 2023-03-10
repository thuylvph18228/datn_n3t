package com.poly.users.repositories;

import com.poly.users.models.Cart;
import com.poly.users.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
