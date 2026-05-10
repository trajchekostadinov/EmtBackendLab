package com.example.emtbackendlab.service.application.Impl;

import com.example.emtbackendlab.helpers.JwtHelper;
import com.example.emtbackendlab.model.domain.User;
import com.example.emtbackendlab.model.dto.LoginUserRequestDto;
import com.example.emtbackendlab.model.dto.LoginUserResponseDto;
import com.example.emtbackendlab.model.dto.RegisterUserRequestDto;
import com.example.emtbackendlab.model.dto.RegisterUserResponseDto;
import com.example.emtbackendlab.service.application.UserApplicationService;
import com.example.emtbackendlab.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

// lab3

@Service
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationServiceImpl(UserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto) {
        User user = userService.register(registerUserRequestDto.toUser());
        RegisterUserResponseDto displayUserDto = RegisterUserResponseDto.from(user);
        return Optional.of(displayUserDto);
    }

    @Override
    public Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto) {
        User user = userService.login(loginUserRequestDto.username(), loginUserRequestDto.password());

        String token = jwtHelper.generateToken(user);

        return Optional.of(new LoginUserResponseDto(token));
    }

    @Override
    public Optional<RegisterUserResponseDto> findByUsername(String username) {
        return userService
                .findByUsername(username)
                .map(RegisterUserResponseDto::from);
    }
}
