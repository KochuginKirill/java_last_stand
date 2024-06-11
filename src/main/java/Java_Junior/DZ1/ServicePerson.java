package Java_Junior.DZ1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class ServicePerson {

  /**
   * Найти самого молодого сотрудника
   */
  public Optional<Person> findMostYoungestPerson(List<Person> people) {
    Optional<Person> person = people.stream()
            .min(Comparator.comparing(Person::getAge));
    return person;
    // FIXME: ваша реализация здесь
  }

  /**
   * Найти департамент, в котором работает сотрудник с самой большой зарплатой
   */
  public Optional<Department> findMostExpensiveDepartment(List<Person> people) {
    Optional<Department> department = Optional.ofNullable(people.stream()
            .max(Comparator.comparing(Person::getSalary))
            .get()
            .getDepart());
    return department;
    // FIXME: ваша реализация здесь
  }

  /**
   * Сгруппировать сотрудников по департаментам
   */
  public Map<Department, List<Person>> groupByDepartment(List<Person> people) {
    return people.stream()
            .collect(Collectors.groupingBy(Person::getDepart));
  }

  /**
   * Сгруппировать сотрудников по названиям департаментов
   */
  public Map<String, List<Person>> groupByDepartmentName(List<Person> people) {
    return people.stream()
            .collect(Collectors.groupingBy(y -> y.getDepart().getName()));

    // FIXME: ваша реализация здесь
  }

//  /**
//   * В каждом департаменте найти самого старшего сотрудника
//   */
//  public Map<String, Person> getDepartmentOldestPerson(List<Person> people) {
//    return people.stream()
//            .collect(Collectors.groupingBy(Person::getDepart))
//            .
//    // FIXME: ваша реализация здесь
//  }
//
//  /**
//   * *Найти сотрудников с минимальными зарплатами в своем отделе
//   * (прим. можно реализовать в два запроса)
//   */
//  public List<Person> cheapPersonsInDepartment(List<Person> people) {
//    // FIXME: ваша реализация здесь
//  }
//
}
