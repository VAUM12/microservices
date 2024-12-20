package com.easybytes.cards.service;

import com.easybytes.cards.dto.CardsDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public interface IcardsService {
    void createCards(String mobileNumber);

    CardsDto fetchCards(@Valid @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);

    boolean updateCards(@Valid CardsDto cardsDto);

    boolean deleteCards(@Valid @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);
}
