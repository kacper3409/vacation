package pl.mcx.vacationplanner.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import pl.mcx.vacationplanner.dto.enums.TicketStatus;
import pl.mcx.vacationplanner.dto.enums.TicketType;
import pl.mcx.vacationplanner.entity.Ticket;


@Builder
@Data
@AllArgsConstructor
public class TicketCreationRequest {

    private String title;

    private String description;

    private Long daysCount;

    private TicketStatus ticketStatus;

    private Boolean active;

    @NonNull
    private Long creatorId;

    @NonNull
    private Long managerId;

    private TicketType type;

    public Ticket toTicket(){
        return Ticket.builder()
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
