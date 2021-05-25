package ru.alishev.springcourse.dto;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;
    private String image_uri;
    private String status;
    private Timestamp timestamp;

}