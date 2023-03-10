package com.poly.users.controllers;

import com.poly.users.models.Cart;
import com.poly.users.models.Products;
import com.poly.users.service.CartService;
import com.poly.users.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @GetMapping("/listCart")
    public String listCart(Model model){
        List<Cart> listCart = cartService.findAll();
        model.addAttribute("cart", listCart);
        return "user/cart/cart";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable String id) {
        Products product = productService.findById(Integer.parseInt(id));
        cartService.addItem(product);
        Cart cart = new Cart();
//        cart.setProducts(cartService.getItems());
        cart.setQuantity(1);
        cartService.create(cart);
        return "redirect:/listCart";
    }
//
//    @PostMapping("/cart")
//    public String removeFromCart(@RequestParam("id") String itemId) {
//        cartService.removeItem(itemId);
//        return "redirect:/listCart";
//    }
}
