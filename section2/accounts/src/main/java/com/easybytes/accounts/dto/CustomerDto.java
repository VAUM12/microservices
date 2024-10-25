package com.easybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold customer and account details",
        requiredProperties = {"name", "email", "mobileNumber"}
)
public class CustomerDto {

    @NotEmpty(message = "Name can not be null or empty")
    @Size(min=5,max=30,message = "Name must be between 5 and 30 characters")
    @Schema(
            description = "Name of the customer",
            example = "John Doe"
    )
    private String name;

    @NotEmpty(message = "Name can not be null or empty")
    @Email(message = "Email should be valid")
    @Schema(
            description = "Email of the customer",
            example = "4gqzQ@example.com"
    )
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be valid")
    @Schema(
            description = "Mobile number of the customer",
            example = "1234567890"
    )
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;

}
