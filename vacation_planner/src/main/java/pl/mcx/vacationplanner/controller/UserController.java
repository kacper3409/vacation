package pl.mcx.vacationplanner.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mcx.vacationplanner.Exceptions.UserNotFoundException;
import pl.mcx.vacationplanner.dto.user.UserCreationRequest;
import pl.mcx.vacationplanner.dto.user.UserDto;
import pl.mcx.vacationplanner.dto.user.UserUpadateRequest;
import pl.mcx.vacationplanner.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user",
        produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE) //test resource
    public Long createUser(@RequestBody UserCreationRequest userCreationRequest) {
        return userService.create(userCreationRequest);
    }

    @PutMapping(value = "/", consumes = APPLICATION_JSON_VALUE)//test resource
    public Long updateUser(@RequestBody UserUpadateRequest updateRequest) {
        return userService.update(updateRequest);
    }

    @GetMapping(value = "/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) throws UserNotFoundException {
        return userService.UserGetUserById(userId);
    }

    @GetMapping(value = "/all")
    public Page<UserDto> getUsers(Pageable pageable){
        return userService.getUsers(pageable);
    }

}
