package com.easybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold account details",
        requiredProperties = {"accountNumber","accountType","branchAddress"}
)
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account number must be 10 digits")
    @NotEmpty(message = "Account number can not be null or empty")
    @Schema(
            description = "AccountNumber of the customer",
            example = "1234567890"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account type can not be null or empty")
    @Schema(
            description = "Account type of the customer",
            example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "Branch address can not be null or empty")
    @Schema(
            description = "Branch address of the customer",
            example = "Pune"
    )
    private String branchAddress;

}
