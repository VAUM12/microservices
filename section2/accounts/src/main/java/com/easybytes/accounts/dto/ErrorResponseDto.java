package com.easybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data@AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold Error Response details"
)
public class ErrorResponseDto {

    @Schema(
        description = "Path of the API"
    )
    private  String apiPath;

    @Schema(
        description = "Status code of the error"
    )
    private HttpStatus errorCode;

    @Schema(
        description = "Message of the error"
    )
    private  String errorMessage;

    @Schema(
        description = "Time of the error"
    )
    private LocalDateTime errorTime;
}
