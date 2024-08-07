package com.devreis.dailydiet.domain.snack.application.usecases;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devreis.dailydiet.domain.snack.enterprise.entity.SnackModel;
import com.devreis.dailydiet.infra.database.SnackRepository;

@Service
public class ListSnacksByUserId {

    private final SnackRepository snackRepository;
    
    public ListSnacksByUserId( SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public List<SnackModel> execute(String userId){
        return this.snackRepository.findAllByUserId(UUID.fromString(userId));
    }
}
