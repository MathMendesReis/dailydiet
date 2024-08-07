package com.devreis.dailydiet.domain.snack.application.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devreis.dailydiet.domain.snack.application.exceptions.SnackNotFoundException;
import com.devreis.dailydiet.infra.database.SnackRepository;
@Service
public class DeleteSnackUseCase {
    private final SnackRepository snackRepository;
    
    public DeleteSnackUseCase( SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public void execute(String snackId){
        var snackDB = this.snackRepository.findById(UUID.fromString(snackId)).orElseThrow(()->{
            throw new SnackNotFoundException("Snack not found with id: " + snackId);
        });

        
        this.snackRepository.delete(snackDB);
    }
}
