package com.devreis.dailydiet.domain.snack.enterprise.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.devreis.dailydiet.domain.user.enterprise.entity.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_snack")
public class SnackModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "snack_id")
    private UUID id;
    @Column(length = 500)
    private String description;
    private String isDiet;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserModel userModel;

    @Column(name = "user_id")
    private UUID userId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public SnackModel() {
    }

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

    public String getIsDiet() {
        return isDiet;
    }

    public void setIsDiet(String isDiet) {
        this.isDiet = isDiet;
    }
}
