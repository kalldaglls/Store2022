package com.forgeeks.api;

public class UserInfoDto {
    private String value;

    public UserInfoDto() {
    }

    public UserInfoDto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
