package com.devreis.dailydiet.domain.snack.application.usecases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.devreis.dailydiet.domain.snack.enterprise.dto.RequestSnackDTO;
import com.devreis.dailydiet.domain.snack.enterprise.entity.SnackModel;
import com.devreis.dailydiet.domain.user.enterprise.exceptions.UserExistsException;
import com.devreis.dailydiet.infra.database.SnackRepository;
import com.devreis.dailydiet.infra.database.UserRepository;

@Service
public class CreateSnackUserCase {

    private SnackRepository snackRepository;
    private UserRepository userRepository;

    public CreateSnackUserCase(SnackRepository snackRepository, UserRepository userRepository) {
        this.snackRepository = snackRepository;
        this.userRepository = userRepository;
    }

    public SnackModel execute(String userId, RequestSnackDTO requestSnackDTO) {
        var user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> {
            throw new UserExistsException();
        });
        SnackModel snackModel = new SnackModel();
        snackModel.setUserId(user.getId());
        snackModel.setDescription(requestSnackDTO.description());
        snackModel.setIsDiet(requestSnackDTO.isDiet());

        return this.snackRepository.save(snackModel);

    }

}
