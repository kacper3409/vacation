package pl.mcx.vacationplanner.dto.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.mcx.vacationplanner.dto.enums.Role;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class UserUpadateRequest {

    private Long id;

    private String userName;

    private String email;

    private Long managerId;

    private Role userRole;

}
