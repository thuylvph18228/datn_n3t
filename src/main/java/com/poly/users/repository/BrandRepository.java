package com.poly.users.repository;

import com.poly.users.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    @Query(value = "select * from brands where name like :name%", nativeQuery = true)
    List<Brand> findByName(String name);

    @Query("select count(id) from Brand ")
    long countById();
}