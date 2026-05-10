package com.example.emtbackendlab.service.domain;

import java.util.Optional;

import com.example.emtbackendlab.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

// lab3

public interface UserService extends UserDetailsService {
    Optional<User> findByUsername(String username);

    User register(User user);

    User login(String username, String password);
}
