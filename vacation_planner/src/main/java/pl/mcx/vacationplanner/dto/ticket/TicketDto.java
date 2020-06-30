package pl.mcx.vacationplanner.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.mcx.vacationplanner.dto.enums.TicketStatus;
import pl.mcx.vacationplanner.dto.enums.TicketType;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class TicketDto {

    private Long id;

    private String title;

    private String description;

    private Long daysCount;

    private TicketStatus ticketStatus;

    private Boolean active;

    private Long creatorId;

    private Long managerId;

    private TicketType type;

    private Date creationDate;

    private Date updateDate;

    private Long updateById;

}
