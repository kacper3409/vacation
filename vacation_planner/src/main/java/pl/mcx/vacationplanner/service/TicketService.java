package pl.mcx.vacationplanner.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.mcx.vacationplanner.dto.ticket.TicketCreationRequest;
import pl.mcx.vacationplanner.dto.ticket.TicketDto;
import pl.mcx.vacationplanner.dto.ticket.TicketUpdateRequest;

public interface TicketService {
    Long createTicket(TicketCreationRequest ticketCreationRequest);

    Long updateTicket(TicketUpdateRequest updateRequest);

    TicketDto findTicketById(Long ticketId);

    Page<TicketDto> findTickets(Pageable pageable);

    Page<TicketDto> findTicketsByManagerId(Long managerId, Pageable pageable);

    Page<TicketDto> findOwnTickets(String userName, Pageable pageable);
}
