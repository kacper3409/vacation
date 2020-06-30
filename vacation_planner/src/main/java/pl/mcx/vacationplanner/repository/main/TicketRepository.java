package pl.mcx.vacationplanner.repository.main;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.vacationplanner.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Page<Ticket> findAllByManagerId(Long managerId, Pageable pageable);

    Page <Ticket> findAllByCreatorId(Long creator, Pageable pageable);
}
