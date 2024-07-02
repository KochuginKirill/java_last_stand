package Spring.lesson1.hw;

import java.time.LocalDateTime;

public class Ticket {
    String number;
    LocalDateTime createdAt;

    public Ticket(String number, LocalDateTime createdAt) {
        this.number = number;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return number + " " + createdAt;
    }
}
