package Java_Core.Seminar3;

public abstract class Worker implements Comparable<Worker> {
    int salary;

    String name;

    public Worker(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract double MonthlySalary();
    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Worker worker){
        return (int) (worker.MonthlySalary() - this.MonthlySalary());
    }

}
