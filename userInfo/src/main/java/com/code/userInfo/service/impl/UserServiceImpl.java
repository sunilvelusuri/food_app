package com.code.userInfo.service.impl;

import com.code.userInfo.dto.UserDto;
import com.code.userInfo.entity.User;
import com.code.userInfo.mapper.UserMapper;
import com.code.userInfo.repository.UserRepo;
import com.code.userInfo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Override
    public UserDto addUser(UserDto userDto) {
        User savedUser = userRepo.save(UserMapper.mapUserDtoToUser(userDto));
        return UserMapper.mapUserToUserDto(savedUser);
    }

    @Override
    public ResponseEntity<UserDto> fetchUserDto(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent())
            return new ResponseEntity<>(UserMapper.mapUserToUserDto(user.get()), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
