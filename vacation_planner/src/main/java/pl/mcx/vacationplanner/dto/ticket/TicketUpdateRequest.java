package pl.mcx.vacationplanner.dto.ticket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import pl.mcx.vacationplanner.dto.enums.TicketStatus;

@Builder
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketUpdateRequest {

    private Long id;

    private TicketStatus ticketStatus;

    private Boolean active;

}
