package Java_Core.Seminar3;

public class NightShift extends Worker {


    public NightShift(int salary, String name) {
        super(salary, name);
    }

    @Override
    double MonthlySalary() {
        return salary;
    }
}
