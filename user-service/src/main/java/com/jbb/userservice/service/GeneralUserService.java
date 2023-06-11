package com.jbb.userservice.service;

import com.jbb.userservice.domain.User;
import com.jbb.userservice.exception.DuplicateUserInfo;
import com.jbb.userservice.repository.UserRepository;
import com.jbb.userservice.request.SignUp;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GeneralUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void signUp(SignUp signUp) {
        userRepository.findByEmail(signUp.getEmail())
                                         .ifPresent(user -> { throw new DuplicateUserInfo(user); });

        userRepository.save(User.builder()
                                .email(signUp.getEmail())
                                .userId(UUID.randomUUID().toString())
                                .name(signUp.getName())
                                .password(signUp.getPassword())
                                .build());
    }

}
