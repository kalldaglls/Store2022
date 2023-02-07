package com.forgeeks.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtRequest {
    private final String username;
    private final String password;

//    public JwtRequest() {
//    }
//
//    public JwtRequest(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
