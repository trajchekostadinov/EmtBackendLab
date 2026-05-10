package com.example.emtbackendlab.model.dto;

import com.example.emtbackendlab.model.domain.User;
import com.example.emtbackendlab.model.enumeration.Role;

public record RegisterUserResponseDto(
        String username,
        String name,
        String surname,
        String email,
        Role role
) {
    public static RegisterUserResponseDto from(User user) {
        return new RegisterUserResponseDto(
                user.getUsername(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getRole()
        );
    }
}
