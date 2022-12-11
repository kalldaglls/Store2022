package com.forgeeks.SpringDZ5.core.controllers;

import com.forgeeks.SpringDZ5.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/userdata")
@RequiredArgsConstructor
public class UserDetailsController {
    private final UserService userService;
//    @GetMapping("/user/{id}")
//    public String getEmailByUsername(@PathVariable Long id) {
//        UserDetails user = userService.findByUserId(id);
//        return user.getPassword();
//    }
}
