package pl.mcx.vacationplanner.repository.main;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mcx.vacationplanner.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUserName(String userName);

    Page<User> findAllByManagerId(Long managerId, Pageable pageable);

}
