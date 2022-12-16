package me.moneld.cc1_panner_achat_monel_dossou.controller;

import jakarta.validation.Valid;
import me.moneld.cc1_panner_achat_monel_dossou.dto.CartDto;
import me.moneld.cc1_panner_achat_monel_dossou.model.Cart;
import me.moneld.cc1_panner_achat_monel_dossou.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartDto> getItems(){
        return cartService.getItems();
    }

    @PostMapping
    public void saveNewItem(@Valid @RequestBody Cart cart){
        cartService.addNewItem(cart);
    }
    @PatchMapping("validate/{cartId}")
    public void validateCart(@PathVariable("cartId") Long cartId){
        cartService.validateCart(cartId);
    }

    @PatchMapping("canceled/{cartId}")
    public void canceledCart(@PathVariable("cartId") Long cartId){
        cartService.canceledCart(cartId);
    }

}
