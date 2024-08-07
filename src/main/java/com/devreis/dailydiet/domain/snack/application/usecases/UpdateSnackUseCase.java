package com.devreis.dailydiet.domain.snack.application.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devreis.dailydiet.domain.snack.application.exceptions.ResourceNotFoundException;
import com.devreis.dailydiet.domain.snack.enterprise.dto.RequestUpdateSnackDTO;
import com.devreis.dailydiet.domain.snack.enterprise.entity.SnackModel;
import com.devreis.dailydiet.infra.database.SnackRepository;

@Service
public class UpdateSnackUseCase {
    private final SnackRepository snackRepository;

    public UpdateSnackUseCase(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public SnackModel execute(String snackId, RequestUpdateSnackDTO requestUpdateSnackDTO) {
        SnackModel updateSnack = snackRepository.findById(UUID.fromString(snackId))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + snackId));

        if (requestUpdateSnackDTO.getDescription() != null && !requestUpdateSnackDTO.getDescription().isEmpty()) {
            updateSnack.setDescription(requestUpdateSnackDTO.getDescription());
        }

        if (requestUpdateSnackDTO.getIsDiet() != null && !requestUpdateSnackDTO.getIsDiet().isEmpty()) {
            updateSnack.setIsDiet(requestUpdateSnackDTO.getIsDiet());
        }

        var snack = this.snackRepository.save(updateSnack);

        return snack;

    }
}
