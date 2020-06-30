package pl.mcx.vacationplanner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mcx.vacationplanner.Exceptions.UserNotFoundException;
import pl.mcx.vacationplanner.dto.user.UserCreationRequest;
import pl.mcx.vacationplanner.dto.user.UserDto;
import pl.mcx.vacationplanner.dto.user.UserShortDto;
import pl.mcx.vacationplanner.dto.user.UserUpadateRequest;
import pl.mcx.vacationplanner.entity.User;

@Service
public interface UserService {
    Long create(UserCreationRequest userCreationRequest);

    Long update(UserUpadateRequest userUpadateRequest);

    UserDto getUserByUserName(String username);

    UserDto UserGetUserById(Long userId) throws UserNotFoundException;

    Page<UserDto> getShortUsersByManagerId(Long managerId, Pageable pageable);

    Page<UserShortDto> getShortUsers(Pageable pageable);

    Page<UserDto> getUsers(Pageable pageable);
}
