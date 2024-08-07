package com.devreis.dailydiet.infra.database;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devreis.dailydiet.domain.snack.enterprise.entity.SnackModel;

public interface SnackRepository extends JpaRepository<SnackModel, UUID>{
    List<SnackModel> findAllByUserId(UUID userId);

    void deleteAllById(UUID fromString);
}
