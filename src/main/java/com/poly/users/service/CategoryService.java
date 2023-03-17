package com.poly.users.service;

import com.poly.users.DTO.CategoryDto;
import com.poly.users.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    Category getById(int categoryId);
    Category getByBrandId(int brandId);
    CategoryDto save(CategoryDto categoryDto);

    @Transactional
    Category save(Category category);

    Category update(Category category);
    Category delete(int id);

    List<Category> getByName(String name);
    List<CategoryDto> getAllBy(List<Integer> all);

}
