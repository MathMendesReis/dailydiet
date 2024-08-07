package com.devreis.dailydiet.domain.snack.enterprise.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO for Snack request")
public record RequestSnackDTO(
        @Schema(description = "Description of the snack", example = "Healthy snack with fruits")
        String description,
        @Schema(description = "Indicates if the snack is diet", allowableValues = {"true", "false"}, example = "true")
        String isDiet) {

}
