package pl.mcx.vacationplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import pl.mcx.vacationplanner.entity.Ticket;
import pl.mcx.vacationplanner.entity.User;

@EntityScan(basePackages = "pl.mcx.vacationplanner.entity")
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

}
