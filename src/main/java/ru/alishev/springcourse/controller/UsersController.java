package ru.alishev.springcourse.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.alishev.springcourse.dto.UsersDto;
import ru.alishev.springcourse.service.UsersService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Log

public class UsersController {

    private final UsersService usersService;

    // Добавление нового пользователя
    // сохранение в базу данных
    // ответ сервера id сохраненного поьлзователя

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUsers(@RequestBody UsersDto usersDto) throws  javax.xml.bind.ValidationException {
        if (usersDto == null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Provide correct User");
        }
        return "userId:" + usersService.saveUser(usersDto).getId();
    }

    // Поучение информации о пользователе
    // Передаем на сервер уникальный Id пользователя
    // Ответ сервера  - персональные данные

    @GetMapping("/find")
    public UsersDto findById(@RequestParam Integer id) {
        return usersService.findById(id);
    }
    // Удаление пользователя
    // Передаем на сервер Id
    // Удаляем информацию из базы
    // ответ сервера: "isDeleted:true"

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteUsers(@PathVariable Integer id) {
        try{
        usersService.deleteUser(id);

    } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", ex);
        }
        return ResponseEntity.ok().body("isDeleted:true");
    }

    // Изменение статуса пользователя
    // Передаем Id и новый status
    // имитируем обращение

    @GetMapping("/status")
    public String setStatus(@RequestParam Integer id, String status) throws InterruptedException,

        javax.xml.bind.ValidationException {

            //иммитация задержки

            log.info("Getting information...");
           TimeUnit.SECONDS.sleep(10);

        String old_status = usersService.findById(id).getStatus();
        UsersDto usersDto =  usersService.findById(id);



        Calendar calendar =  Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));

        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        System.out.println(timestamp);
        usersDto.setTimestamp(timestamp);

        usersDto.setStatus(status);

        usersService.saveUser(usersDto);
        String new_status = usersService.findById(id).getStatus();

            return " id:"+ id + " old_status:" + old_status + " new_status:" + new_status ;

    }}
