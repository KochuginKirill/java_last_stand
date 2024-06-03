package Java_Development_Kit.DZ5;

public class Main {
    public static void main(String[] args) throws Exception {
        final Philosopher[] philosophers = new Philosopher[5];
        final Object[] forks = new Object[philosophers.length];
        WellFed wellFed = new WellFed(5);
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];
            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork, wellFed);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork, wellFed);
            }
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
