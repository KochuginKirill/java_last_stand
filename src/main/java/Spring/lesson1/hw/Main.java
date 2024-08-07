package Spring.lesson1.hw;

import Spring.lesson1.Application;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
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
