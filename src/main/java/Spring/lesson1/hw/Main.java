package Spring.lesson1.hw;

import Spring.lesson1.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println(context.getBean(Table.class).newTicket());
        System.out.println();
        Thread.sleep(10);
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println(context.getBean(Table.class).newTicket());
        Thread.sleep(10);
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println(context.getBean(Table.class).newTicket());
        Thread.sleep(10);
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
        context.close();
    }
}
