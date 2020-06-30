package pl.mcx.vacationplanner.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.mcx.vacationplanner.dto.ticket.TicketCreationRequest;
import pl.mcx.vacationplanner.dto.ticket.TicketDto;
import pl.mcx.vacationplanner.dto.ticket.TicketUpdateRequest;
import pl.mcx.vacationplanner.dto.user.UserDto;
import pl.mcx.vacationplanner.entity.Ticket;
import pl.mcx.vacationplanner.repository.main.TicketRepository;

import static java.util.Optional.ofNullable;


@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    private final UserService userService;

    public TicketServiceImpl(TicketRepository ticketRepository, UserService userService) {
        this.ticketRepository = ticketRepository;
        this.userService = userService;
    }

    @Override
    public Long createTicket(TicketCreationRequest ticketCreationRequest) {
        return ticketRepository.save(ticketCreationRequest.toTicket()).getId();
    }

    @Override
    public Long updateTicket(TicketUpdateRequest updateRequest) {
        Ticket ticket = ticketRepository.getOne(updateRequest.getId());
        fillUpdatableFields(updateRequest, ticket);
        return ticketRepository.save(ticket).getId();
    }

    @Override
    public TicketDto findTicketById(Long ticketId){
       return ticketRepository.getOne(ticketId).toDto();
    }

    @Override
    public Page<TicketDto> findTickets(Pageable pageable) {
        return ticketRepository.findAll(pageable).map(Ticket::toDto);
    }

    @Override
    public Page<TicketDto> findTicketsByManagerId(Long managerId, Pageable pageable) {
        return ticketRepository.findAllByManagerId(managerId,pageable).map(Ticket::toDto);
    }

    @Override
    public Page<TicketDto> findOwnTickets(String userName, Pageable pageable){
        UserDto userByUserName = userService.getUserByUserName(userName);
        return ticketRepository.findAllByCreatorId(userByUserName.getId(), pageable).map(Ticket::toDto);
    }

    private void fillUpdatableFields(TicketUpdateRequest updateRequest, Ticket ticket) {
        ofNullable(updateRequest.getActive()).ifPresent(ticket::setActive);
        ofNullable(updateRequest.getTicketStatus()).ifPresent(ticket::setTicketStatus);
    }



}
