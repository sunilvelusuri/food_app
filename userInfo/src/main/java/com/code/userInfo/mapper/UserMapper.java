package com.code.userInfo.mapper;

import com.code.userInfo.dto.UserDto;
import com.code.userInfo.entity.User;

public class UserMapper {
    public static User mapUserDtoToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getAddress(),
                userDto.getCity()
        );
    return user;
    }

    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getAddress(),
                user.getCity()
        );
        return userDto;
    }
}
