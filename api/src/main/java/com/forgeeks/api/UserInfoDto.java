package com.forgeeks.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDto {
    private final String value;

//    public UserInfoDto() {
//    }
//
//    public UserInfoDto(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
}
