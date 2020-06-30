package pl.mcx.vacationplanner.entity;

import lombok.*;
import pl.mcx.vacationplanner.dto.ticket.TicketDto;
import pl.mcx.vacationplanner.dto.enums.TicketStatus;
import pl.mcx.vacationplanner.dto.enums.TicketType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(schema = "public", name = "ticket")
@Data
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "days_count")
    private Long daysCount;

    @Column(name = "ticket_status")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    private Boolean active;

    @NonNull
    @Column(name = "creator_id")
    private Long creatorId;

    @NonNull
    @Column(name = "manager_id")
    private Long managerId;

    @Enumerated(EnumType.STRING)
    private TicketType type;

    @NonNull
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "update_by_id")
    private Long updateById;

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = new Date();
    }

    public TicketDto toDto(){
        return TicketDto.builder()
                .title(title)
                .creatorId(creatorId)
                .description(description)
                .active(active)
                .daysCount(daysCount)
                .ticketStatus(ticketStatus)
                .managerId(managerId)
                .type(type)
                .build();
    }
}
