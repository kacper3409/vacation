package pl.mcx.vacationplanner.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mcx.vacationplanner.dto.user.UserDto;
import pl.mcx.vacationplanner.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/manager",
        produces = APPLICATION_JSON_VALUE)
public class ManagerController {

    private final UserService userService;

    public ManagerController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{managerId}")
    public Page<UserDto> getUsersByManager(@PathVariable(value = "managerId") Long managerId,
                                           Pageable pageable){
        return userService.getShortUsersByManagerId(managerId, pageable);
    }
}
