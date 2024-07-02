package Spring.lesson1.hw;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Scope(ConfigurableListableBeanFactory.SCOPE_SINGLETON)
public class TicketNumberGenerator {

    public String createNewNumber(){
        return "Ticket # " + UUID.randomUUID();
    }
}
