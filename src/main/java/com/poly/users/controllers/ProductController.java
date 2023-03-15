package com.poly.users.controllers;

import com.poly.users.models.Products;
import com.poly.users.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/index")
    public ResponseEntity<?> getAllProduct(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        Page<Products> products = this.productService.getAll(page, size);
        Long totalProduct = products.getTotalElements();
//        List<ProductDto> list = products.stream().map(Product::toDto).collect(Collectors.toList());
        Integer allPage = products.getTotalPages();
        List<Object> object = new ArrayList<>();
//        object.add(list);
        object.add(allPage);
        object.add(totalProduct);
        return ResponseEntity.ok(object);
    }
}
