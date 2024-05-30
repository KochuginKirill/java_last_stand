package Java_Development_Kit.DZ4;

import java.util.ArrayList;

public class Employee {
    private Integer tableNumber;
    private ArrayList<String> telephoneNumber;
    private String name;
    private ArrayList<String> workExperience;

    public Employee(Integer tableNumber, String telephoneNumber,
                    String name, String workExperience) {

        this.tableNumber = tableNumber;
        this.telephoneNumber = new ArrayList<>();
        this.telephoneNumber.add(telephoneNumber);
        this.name = name;
        this.workExperience = new ArrayList<>();
        this.workExperience.add(workExperience);
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public ArrayList<String> getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWorkExperience() {
        return workExperience;
    }

    @Override
    public String toString(){
        return String.format("%s %s %s %s", name, tableNumber.toString(),
                telephoneNumber.toString(), workExperience.toString());
    }

    void addTelephoneNumber(String number){
        telephoneNumber.add(number);
    }

    void addWorkExperience(String experience){
        workExperience.add(experience);
    }
}
