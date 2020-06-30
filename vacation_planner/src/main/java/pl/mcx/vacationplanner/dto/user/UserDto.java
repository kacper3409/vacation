package pl.mcx.vacationplanner.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import pl.mcx.vacationplanner.dto.enums.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String userName;

    private String email;


    private Long managerId;

    private Role userRole;

    private Date creationDate;

    private Date updateDate;

}
