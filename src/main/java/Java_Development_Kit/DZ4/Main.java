package Java_Development_Kit.DZ4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeesDB employeesDB = new EmployeesDB();

        Employee employee1 = new Employee(12345,
                "+7-343-343-33-33",
                "Petya",
                "Worked in this company for 7 years");

        Employee employee2 = new Employee(54321,
                "+7-843-843-83-83",
                "Sasha",
                "Worked in another company fo 5 years");

        Employee employee3 = new Employee(77777,
                "+7-666-666-66-6",
                "Nastya",
                "Worked in yet another company fo 20 years");

        employeesDB.add(employee1);
        employeesDB.add(employee2);
        employeesDB.add(employee3);

        System.out.println();
        System.out.println("Телефонный номер искомого сотрудника: "
                + employeesDB.getTelephoneByName("Sasha"));
        System.out.println();
        System.out.println(employeesDB.
                getEmployeeByWorkExperience("yet another company fo 20 years"));
        System.out.println();
        System.out.println(employeesDB.getEmployeeByTableNumber(12345));
    }
}
