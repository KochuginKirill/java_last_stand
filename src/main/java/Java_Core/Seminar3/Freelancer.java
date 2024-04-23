package Java_Core.Seminar3;

public class Freelancer extends Worker {


    public Freelancer(int salary, String name) {
        super(salary, name);
    }

    @Override
    double MonthlySalary() {
        return 20.8 * 8 * salary;
    }
}
