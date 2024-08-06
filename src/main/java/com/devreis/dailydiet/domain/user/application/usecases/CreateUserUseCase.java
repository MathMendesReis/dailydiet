package com.devreis.dailydiet.domain.user.application.usecases;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devreis.dailydiet.domain.user.enterprise.dto.CreateUserRequestDTO;
import com.devreis.dailydiet.domain.user.enterprise.entity.UserModel;
import com.devreis.dailydiet.domain.user.enterprise.exceptions.UserExistsException;
import com.devreis.dailydiet.infra.database.UserRepository;

@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserModel execute(CreateUserRequestDTO body) {
        // verifica se o usuario ja existe no DB
        this.userRepository.findByEmail(body.email()).ifPresent(user -> {
          throw new UserExistsException();
        });
        //Criptografando senha
        String encryptedPassword = new BCryptPasswordEncoder().encode(body.passaword());
        //criando usuario no db
        UserModel userModel = new UserModel();
        userModel.setEmail(body.email());
        userModel.setPassaword(encryptedPassword);
        //salvar usuario no db
        return userRepository.save(userModel);

    }

}
