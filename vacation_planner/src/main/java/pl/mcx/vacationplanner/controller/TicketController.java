package pl.mcx.vacationplanner.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mcx.vacationplanner.dto.ticket.TicketCreationRequest;
import pl.mcx.vacationplanner.dto.ticket.TicketDto;
import pl.mcx.vacationplanner.dto.ticket.TicketUpdateRequest;
import pl.mcx.vacationplanner.service.TicketService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/ticket",
        produces = APPLICATION_JSON_VALUE)
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    public Long createTicket(@RequestBody TicketCreationRequest ticketCreationRequest) {
        return ticketService.createTicket(ticketCreationRequest);
    }

    @PutMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    public Long updateTicket(@RequestBody TicketUpdateRequest updateRequest) {
        return ticketService.updateTicket(updateRequest);
    }

    @GetMapping(value = "/")
    public Page<TicketDto> getTickets(Pageable pageable) {
        return ticketService.findTickets(pageable);
    }

    @GetMapping(value = "/{ticketId}")
    public TicketDto getTicket(@PathVariable (value = "ticketId") Long ticketId) {
        return ticketService.findTicketById(ticketId);
    }

    @GetMapping(value = "user/{managerId}")
    public Page<TicketDto> getTicketByOwnerId(@PathVariable (value = "managerId") Long ticketId, Pageable pageable) {
        return ticketService.findTicketsByManagerId(ticketId, pageable);
    }

}
