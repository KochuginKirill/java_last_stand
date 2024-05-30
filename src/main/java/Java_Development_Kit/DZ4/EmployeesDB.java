package Java_Development_Kit.DZ4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeesDB {
    Integer id;
    HashMap<Integer, Employee> dataBase;

    public EmployeesDB() {
        this.id = 0;
        this.dataBase = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public HashMap<Integer, Employee> getDataBase() {
        return dataBase;
    }

    public Employee getEmployeeByWorkExperience(String searchWorkExperience){
        for (Map.Entry<Integer, Employee> entry: dataBase.entrySet()){
            if (entry.getValue().getWorkExperience().toString().contains(searchWorkExperience)){
                return entry.getValue();
            }
        }
        return null;
    }

    public ArrayList<String> getTelephoneByName(String searchName){
        for (Map.Entry<Integer, Employee> entry: dataBase.entrySet()){
            if (entry.getValue().getName() == searchName){
                return entry.getValue().getTelephoneNumber();
            }
        }
        return null;
    }

    public Employee getEmployeeByTableNumber(Integer tableNumber){
        for (Map.Entry<Integer, Employee> entry: dataBase.entrySet()){
            if (entry.getValue().getTableNumber().equals(tableNumber)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void add(Employee employee){
        dataBase.put(id++, employee);
    }


}
