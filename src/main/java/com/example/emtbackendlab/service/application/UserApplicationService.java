package com.example.emtbackendlab.service.application;


import com.example.emtbackendlab.model.dto.LoginUserRequestDto;
import com.example.emtbackendlab.model.dto.LoginUserResponseDto;
import com.example.emtbackendlab.model.dto.RegisterUserRequestDto;
import com.example.emtbackendlab.model.dto.RegisterUserResponseDto;

import java.util.Optional;

// lab3

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
