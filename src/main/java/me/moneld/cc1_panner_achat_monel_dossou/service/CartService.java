package me.moneld.cc1_panner_achat_monel_dossou.service;

import jakarta.transaction.Transactional;
import me.moneld.cc1_panner_achat_monel_dossou.dto.CartDto;
import me.moneld.cc1_panner_achat_monel_dossou.model.Cart;
import me.moneld.cc1_panner_achat_monel_dossou.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartDto> getItems(){
            return  cartRepository.findAll()
                    .stream()
                    .map(this::convertEntityToDto)
                    .collect(Collectors.toList());
    }

    public void addNewItem(Cart cart) {
        cartRepository.save(cart);
    }

    @Transactional
    public void validateCart(Long cartId) {
      Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalStateException("Cart not exist"));
      if (cart.getStatus() != "IN_PROGRESS"){
          throw new IllegalStateException("The cart cannot be validated");
      }
      cart.setStatus("VALIDATE");
    }

    @Transactional
    public void canceledCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalStateException("Cart not exist"));
        if (cart.getStatus() != "IN_PROGRESS"){
            throw new IllegalStateException("The cart cannot be deleted");
        }
        cart.setStatus("CANCELED");
    }


    private CartDto convertEntityToDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setCustomerId(cart.getCustomerId());
        cartDto.setProductId(cart.getProductId());
        cartDto.setQuantity(cart.getQuantity());
        cartDto.setAmount(cart.getAmount());
        cartDto.setStatus(cart.getStatus());

        return cartDto;
    }
}
