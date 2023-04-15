package com.forgeeks.SpringDZ5.auth.controllers;

import com.forgeeks.SpringDZ5.auth.service.UserService;
import com.forgeeks.api.RegisterUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// Домашнее задание:
// 1. Разобраться с кодом
// 2. Добавьте необходимость указания адреса доставки и номера телефона при оформлении заказа
// 3. Регистрация новых пользователей
// 4. * Мерж корзин. После того как пользователь залогинился, необходимо на бэке смержить
// гостевую и корзину пользователя


@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public void registrateNewUser(@RequestBody RegisterUserDto registerUserDto) {
        // TODO полностью реализовать метод, как считаете нужным
        //  ниже всего лишь пример хеширования паролей
        String bcryptCachedPassword = passwordEncoder.encode(registerUserDto.getPassword());
    }
}
