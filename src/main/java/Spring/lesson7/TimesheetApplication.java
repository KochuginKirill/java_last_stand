package Spring.lesson7;

import Spring.lesson7.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import Spring.lesson7.model.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class TimesheetApplication {

  /**
   * spring-data - ...
   * spring-data-jdbc - зависимость, которая предоставляет удобные преднастроенные инструемнты
   * для работы c реляционными БД
   * spring-data-jpa - зависимость, которая предоставляет удобные преднастроенные инструемнты
   * для работы с JPA
   * spring-data-jpa
   * /
   * /
   * jpa   <------------- hibernate (ecliselink ...)
   * <p>
   * spring-data-mongo - завимость, которая предоставляет инструменты для работы с mongo
   * spring-data-aws
   */

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(TimesheetApplication.class, args);

    // 1. пользователь регистрируется на сайте и вводит свой пароль
    // 1.1 сервер считает хеш от пароля и сохраняет его в бд = hashInDatabase
    // 2. пользователь логинится на сайт и вводит свой пароль
    // 2.1 сервер считает хеш от пароля и сравнивает его с хешом в БД
    // hashFunc(password) -> hashInDatabase
    // hash -> password !!!
    // username1, password => hash(username1 + _ + password) == hash1
    // username2, password => hash(username2 + _ + password) == hash2

    // hashFunc(rawPassword) == hashInDatabase

    Role adminRole = new Role("admin", 1L);
    Role anonymousRole = new Role("anonymous", 2L);
    Role userRole = new Role("user", 3L);
    RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
    roleRepository.save(adminRole);
    roleRepository.save(anonymousRole);
    roleRepository.save(userRole);

    UserRepository userRepository = ctx.getBean(UserRepository.class);
    User admin = new User();
    admin.setLogin("admin");
    admin.setPassword("$2a$12$LbAPCsHn8ZN5MUDqDmIX7e9n1YlDkCxEt0lW3Q2WuW0M1vteo8jvG");
    admin.setRoleId(1L);// admin
    User user = new User();
    user.setLogin("user");
    user.setPassword("$2a$12$.dlnBAYq6sOUumn3jtG.AepxdSwGxJ8xA2iAPoCHSH61Vjl.JbIfq");
    user.setRoleId(3L);
    User anonymous = new User();
    anonymous.setLogin("anon");
    anonymous.setPassword("$2a$12$tPkyYzWCYUEePUFXUh3scesGuPum1fvFYwm/9UpmWNa52xEeUToRu");
    anonymous.setRoleId(2L);// anon
    userRepository.save(admin);
    userRepository.save(user);
    userRepository.save(anonymous);

    ProjectRepository projectRepo = ctx.getBean(ProjectRepository.class);
    for (int i = 1; i <= 5; i++) {
      Project project = new Project();
      project.setName("Project #" + i);
      projectRepo.save(project);
    }

    TimesheetRepository timesheetRepo = ctx.getBean(TimesheetRepository.class);

    LocalDate createdAt = LocalDate.now();
    for (int i = 1; i <= 10; i++) {
      createdAt = createdAt.plusDays(1);

      Timesheet timesheet = new Timesheet();
      timesheet.setProjectId(ThreadLocalRandom.current().nextLong(1, 6));
      timesheet.setCreatedAt(createdAt);
      timesheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));

      timesheetRepo.save(timesheet);
    }
  }

}
