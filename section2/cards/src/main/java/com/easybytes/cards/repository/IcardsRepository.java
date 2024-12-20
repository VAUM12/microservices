package com.easybytes.cards.repository;

import com.easybytes.cards.entity.Cards;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IcardsRepository extends JpaRepository<Cards, Long> {
    Optional<Cards> findByMobileNumber(String mobileNumber);

    Optional<Cards> findByCardNumber(@NotEmpty(message = "Card Number is required") @Pattern(regexp = "^[0-9]{12}$", message = "CardNumber must be 12 digits") String cardNumber);
}
