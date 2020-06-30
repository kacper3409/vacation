package pl.mcx.vacationplanner.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.mcx.vacationplanner.dto.enums.Role;
import pl.mcx.vacationplanner.entity.User;

@Builder
@Data
@AllArgsConstructor
public class UserCreationRequest {

    private String userName;

    private String email;

    private Long managerId;

    private Role userRole;


    public User toUser(){
      return User.builder()
                .email(email)
                .managerId(managerId)
                .userRole(userRole)
                .userName(userName)
                .build();
    }

}
