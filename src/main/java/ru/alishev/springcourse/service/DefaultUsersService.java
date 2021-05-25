package ru.alishev.springcourse.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alishev.springcourse.dto.UsersDto;
import ru.alishev.springcourse.entity.Users;
import ru.alishev.springcourse.repository.UsersRepository;

import javax.xml.bind.ValidationException;

import java.sql.Timestamp;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;


    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getName()) || usersDto.getName().isEmpty()) {
            throw new ValidationException("Name is empty");
        }

        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
        if (isNull(usersDto.getEmail()) || usersDto.getEmail().isEmpty()) {
            throw new ValidationException("Email is empty");
        }

        if (isNull(usersDto.getImage_uri()) || usersDto.getImage_uri().isEmpty()) {
            throw new ValidationException("imageURI is empty");
        }

        if (isNull(usersDto.getStatus()) || usersDto.getStatus().isEmpty()) {
            throw new ValidationException("status is empty");
        }
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }


    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findById(Integer userId) {
        Users users = usersRepository.findById(userId).get();
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }
 @Override

    public List<UsersDto> findUsersByStatusAndTimestampAfter (String status, Timestamp timestamp) {
        return usersRepository.findUsersByStatusAndTimestampAfter(status,timestamp);

    }

}
