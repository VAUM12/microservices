package com.easybytes.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CardsDto {

    @NotEmpty(message = "Mobile Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile Number is not valid")
    private String mobileNumber;

    @NotEmpty(message = "Card Number is required")
    @Pattern(regexp = "^[0-9]{12}$", message = "CardNumber must be 12 digits")
    private String cardNumber;

    @NotEmpty(message = "Card Type is required")
    private String cardType;

    @Positive(message = "Total Limit should be greater than 0")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private int amountUsed;

    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;

}
