package com.devreis.dailydiet.domain.snack.enterprise.dto;



public class RequestUpdateSnackDTO {
    private String description;
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
