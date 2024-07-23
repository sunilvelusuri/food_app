package com.code.userInfo.service;


import com.code.userInfo.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto addUser(UserDto userDto);
    ResponseEntity<UserDto> fetchUserDto(Integer userId);
}
