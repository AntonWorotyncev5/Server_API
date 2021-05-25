package ru.alishev.springcourse.service;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.dto.UsersDto;
import ru.alishev.springcourse.entity.Users;

@Component
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        users.setEmail(usersDto.getEmail());
        users.setImage_uri(usersDto.getImage_uri());
        users.setStatus(usersDto.getStatus());
        users.setTimestamp(usersDto.getTimestamp());
        return users;
    }

    public UsersDto fromUserToUserDto(Users users) {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setName(users.getName());
        usersDto.setLogin(users.getLogin());
        usersDto.setEmail(users.getEmail());
        usersDto.setImage_uri(users.getImage_uri());
        usersDto.setStatus(users.getStatus());
        usersDto.setTimestamp(users.getTimestamp());
        return usersDto;
    }


}