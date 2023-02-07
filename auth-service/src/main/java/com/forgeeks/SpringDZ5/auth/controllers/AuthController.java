package com.forgeeks.SpringDZ5.auth.controllers;


import com.forgeeks.SpringDZ5.auth.entities.User;
import com.forgeeks.SpringDZ5.auth.service.UserService;
import com.forgeeks.SpringDZ5.auth.utils.JwtTokenUtil;
import com.forgeeks.api.JwtRequest;
import com.forgeeks.api.JwtResponse;
import com.forgeeks.api.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/auth")
//@CrossOrigin("*")
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/about")
    public UserInfoDto getCurrentUserInfo(Principal principal){
        User user = userService.findByUsername(principal.getName()).get();
        return new UserInfoDto(user.getUsername() + " " +   user.getEmail());
    }
}
