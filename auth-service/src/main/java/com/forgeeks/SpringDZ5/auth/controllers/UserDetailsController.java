package com.forgeeks.SpringDZ5.auth.controllers;

import com.forgeeks.SpringDZ5.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/userdata")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserDetailsController {
    private final UserService userService;
    @GetMapping("/user/{id}")
    public String getEmailByUsername(@PathVariable Long id) {
        UserDetails user = userService.findByUserId(id);
        return user.getPassword();
    }
}
