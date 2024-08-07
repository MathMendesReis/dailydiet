package com.devreis.dailydiet.infra.database;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devreis.dailydiet.domain.user.enterprise.entity.UserModel;
public interface UserRepository extends JpaRepository<UserModel, UUID>{
    
 Optional<UserModel> findByEmail(String email);   
}
