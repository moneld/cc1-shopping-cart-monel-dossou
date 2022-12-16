package me.moneld.cc1_panner_achat_monel_dossou.config;

import me.moneld.cc1_panner_achat_monel_dossou.model.Cart;
import me.moneld.cc1_panner_achat_monel_dossou.repository.CartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class CartConfig {

    @Bean
    CommandLineRunner commandLineRunner(CartRepository cartRepository){
        return args -> {
            Cart items1 = new Cart(
                    1,
                    1,
                    5,
                    500
            );

            Cart items2 = new Cart(
                    1,
                    10,
                    1,
                    1500
            );

            cartRepository.saveAll(List.of(items1,items2));
        };
    }
}
