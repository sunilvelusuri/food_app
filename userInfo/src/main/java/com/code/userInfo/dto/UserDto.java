package com.code.userInfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor

public class UserDto {

    private Long id;
    private String userName;
    private String password;
    private String address;
    private String city;
}
