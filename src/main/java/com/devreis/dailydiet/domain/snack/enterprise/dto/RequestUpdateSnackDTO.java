package com.devreis.dailydiet.domain.snack.enterprise.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO for updating a Snack")
public class RequestUpdateSnackDTO {
    @Schema(description = "Description of the snack", example = "Healthy snack with fruits")
    private String description;
    @Schema(description = "Indicates if the snack is diet", allowableValues = {"true", "false"}, example = "true")
    private String isDiet;
    public RequestUpdateSnackDTO() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIsDiet() {
        return isDiet;
    }
    public void setIsDiet(String isDiet) {
        this.isDiet = isDiet;
    }


}
