package ru.alishev.springcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.dto.UsersDto;
import ru.alishev.springcourse.entity.Users;

import java.sql.Timestamp;
import java.util.List;

@Repository

public interface UsersRepository extends JpaRepository<Users, Integer> {

    List<UsersDto>findUsersByStatusAndTimestampAfter(String status, Timestamp timestamp);

}
