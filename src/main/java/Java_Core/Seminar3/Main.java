package Java_Core.Seminar3;

public class Main {
    public static void main(String[] args) {
        WorkerDB workers = new WorkerDB();
        NightShift Kolya = new NightShift(70000, "Kolya");
        workers.addWorkers(Kolya);
        NightShift Petya = new NightShift(65000, "Petya");
        workers.addWorkers(Petya);
        Freelancer Sasha = new Freelancer(600, "Sasha");
        workers.addWorkers(Sasha);
        Freelancer Pasha = new Freelancer(500, "Pasha");
        workers.addWorkers(Pasha);
        System.out.println("Рейтинг по ежемесячным зарплатам: ");
        workers.sortWorkers();
        for (int i = 0; i < workers.getWorkers().size(); i++) {
            System.out.println(i + 1 + ") " + workers.getWorkers().get(i).getName()
                    + " " + workers.getWorkers().get(i).MonthlySalary());
        }
    }
}
