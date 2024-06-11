package Java_Junior.DZ1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ServicePerson servicePerson = new ServicePerson();

        Department Sales = new Department("Sales");
        Department It = new Department("It");

        Person petya = new Person("Petya", 27, 80000.0, Sales);
        Person sasha = new Person("Sasha", 29, 70000.0, Sales);
        Person pasha = new Person("Pasha", 25, 60000.0, Sales);
        Person masha = new Person("Masha", 22, 90000.0, It);
        Person borya = new Person("Borya", 30, 100000.0, It);

        List<Person> personList = new ArrayList<>();

        personList.add(petya);
        personList.add(sasha);
        personList.add(pasha);
        personList.add(masha);
        personList.add(borya);

        System.out.println("Самый молодой сотрудник: "
                + servicePerson.findMostYoungestPerson(personList).get().getName());
        System.out.println();

        System.out.println("Департамент, в котором работает сотрудник с самой большой зарплатой: " +
                servicePerson.findMostExpensiveDepartment(personList).get().getName());
        System.out.println();

        System.out.println("Группировка по департаментам:");
        Map<Department, List<Person>> personMapSortedByDepartment = servicePerson.groupByDepartment(personList);
        personMapSortedByDepartment.entrySet().stream()
                .forEach(e -> e.getValue().stream()
                        .forEach(p -> System.out.println(p.getDepart().getName() + " " + p.getName())));
        System.out.println();

        System.out.println("Группировка по названию департаментов:");
        Map<String, List<Person>> personMapSortedByDepartmentName = servicePerson.groupByDepartmentName(personList);
        personMapSortedByDepartmentName.entrySet().stream()
                .forEach(e -> e.getValue().stream()
                        .forEach(p -> System.out.println(p.getDepart().getName() + " " + p.getName())));
        System.out.println();

        System.out.println("Cамый старший сотрудник в департаменте: ");
        Map<String, Person> personMaxAgeInDepartment = servicePerson.getDepartmentOldestPerson(personList);
        personMaxAgeInDepartment.entrySet().stream()
                .forEach(e -> System.out.println(e.getValue().getDepart().getName() + " " +
                        e.getValue().getName() + " " +
                        e.getValue().getAge()));
    }
}
