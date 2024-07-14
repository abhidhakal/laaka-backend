package com.example.workshop.service;

import com.example.workshop.entity.Cart;
import java.util.List;
import java.util.Optional;

public interface CartService {
    List<Cart> getAllCarts();
    Optional<Cart> getCartById(Integer id);
    Cart createCart(Cart cart);
    Cart updateCart(Integer id, Cart cartDetails);
    void deleteCart(Integer id);
}
