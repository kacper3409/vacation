package pl.mcx.vacationplanner.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.mcx.vacationplanner.dto.enums.Role;

@Builder
@Data
@AllArgsConstructor
public class UserShortDto {

    private Long id;

    private String userName;

    private Role userRole;

    private String email;

}
