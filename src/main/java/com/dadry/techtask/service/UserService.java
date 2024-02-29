package com.dadry.techtask.service;

import com.dadry.techtask.entity.User;
import com.dadry.techtask.entity.enums.Role;
import com.dadry.techtask.payload.request.SignupRequest;
import com.dadry.techtask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final CustomPasswordEncoder customPasswordEncoder;

    public User createUser(SignupRequest request) {
        User user = new User();

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(customPasswordEncoder.getPasswordEncoder().encode(request.getPassword()));
        user.getRoles().add(Role.ROLE_USER);

        try {
            log.info("Saving user {}", user.getUsername());
            return userRepository.insert(user);
        } catch (Exception e) {
            log.error("Error during registration! {}", e.getMessage());
            throw new RuntimeException("The user " + user.getUsername() + " already exists!");
        }
    }
}
