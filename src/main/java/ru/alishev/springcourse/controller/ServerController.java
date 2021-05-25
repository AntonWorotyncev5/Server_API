package ru.alishev.springcourse.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.dto.UsersDto;
import ru.alishev.springcourse.service.UsersService;
import java.sql.Timestamp;
import java.util.List;


@RestController

@RequestMapping(value = "/statistics",produces = MediaType.APPLICATION_JSON_VALUE)

public class ServerController {

    private final UsersService usersService;

    public ServerController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/sort")
    @ResponseStatus(HttpStatus.FOUND)
    public List<UsersDto> statistics (@RequestParam(required = false)  String status , Timestamp timestamp)
            throws  javax.xml.bind.ValidationException {

        List<UsersDto> foundUsers = null;

        // если параметры указанны , формируем список - ответ по ним

        if ((status != null) && (timestamp != null)) {

                foundUsers  = usersService.findUsersByStatusAndTimestampAfter(status,timestamp);

        }
            return foundUsers;

        }
    }







