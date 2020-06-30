package pl.mcx.vacationplanner.entity;

import lombok.*;
import pl.mcx.vacationplanner.dto.enums.Role;
import pl.mcx.vacationplanner.dto.user.UserDto;
import pl.mcx.vacationplanner.dto.user.UserShortDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(schema = "public", name = "user")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    private String email;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = new Date();
    }

    public UserDto toDto(){
        return UserDto.builder()
                .email(email)
                .id(id)
                .creationDate(creationDate)
                .managerId(managerId)
                .updateDate(updateDate)
                .userName(userName)
                .userRole(userRole)
                .build();
    }

    public UserShortDto toShortDto(){
        return UserShortDto.builder()
                .id(id)
                .email(email)
                .userName(userName)
                .userRole(userRole)
                .build();
    }

}
