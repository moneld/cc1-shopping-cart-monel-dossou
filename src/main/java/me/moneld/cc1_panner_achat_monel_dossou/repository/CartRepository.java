package me.moneld.cc1_panner_achat_monel_dossou.repository;


import me.moneld.cc1_panner_achat_monel_dossou.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
