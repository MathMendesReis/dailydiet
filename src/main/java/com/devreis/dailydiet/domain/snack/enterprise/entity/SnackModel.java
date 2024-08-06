package com.devreis.dailydiet.domain.snack.enterprise.entity;

import java.time.LocalDateTime;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_snack")
public class SnackModel {
    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private Boolean isDiet;

    public SnackModel(){}
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getIsDiet() {
        return isDiet;
    }
    public void setIsDiet(Boolean isDiet) {
        this.isDiet = isDiet;
    }
}
