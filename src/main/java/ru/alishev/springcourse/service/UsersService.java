package ru.alishev.springcourse.service;

import ru.alishev.springcourse.dto.UsersDto;

import java.sql.Timestamp;
import java.util.List;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto) throws javax.xml.bind.ValidationException;

    UsersDto findById(Integer userId);

    void deleteUser(Integer userId);

    List<UsersDto>findUsersByStatusAndTimestampAfter(String status, Timestamp timestamp);







}