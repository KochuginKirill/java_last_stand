package Spring.lesson1.hw;

import Spring.lesson1.scope.Singleton;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@Scope("singleton")
public class Table {

    private TicketNumberGenerator ticketNumberGenerator;

    public Table(TicketNumberGenerator ticketNumberGenerator) {
        Objects.requireNonNull(ticketNumberGenerator);
        this.ticketNumberGenerator = ticketNumberGenerator;
    }

    public Ticket newTicket(){
        return new Ticket(this.ticketNumberGenerator.createNewNumber(), LocalDateTime.now());
    }

}
