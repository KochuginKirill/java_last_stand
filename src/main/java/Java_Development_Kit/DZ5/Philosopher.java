package Java_Development_Kit.DZ5;

public class Philosopher implements Runnable{

    private Object leftFork;
    private Object rightFork;

    private WellFed wellFed;

    private int counter;

    @Override
    public void run() {
        try {
            while (true) {
                if(counter < 3) {
                    currentStatus("Думает");
                    synchronized (leftFork) {
                        currentStatus("Взял левую вилку");
                        synchronized (rightFork) {
                            currentStatus("Взял правую вилку и ест");
                            counter++;
                            currentStatus("Положил правую вилку");
                        }
                        currentStatus("Положил левую вилку и думает");
                    }
                } else {
                    currentStatus("Сытый и думает");
                    wellFed.WellFedIncrease();
                    if (wellFed.getWellFed() == wellFed.getMaxFed()){
                        System.out.println("Все поели 3 раза и могут спокойно филосовствовать");
                        System.exit(0);
                    }
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Philosopher(Object leftFork, Object rightFork, WellFed wellFed) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.wellFed = wellFed;
    }

    private void currentStatus(String status) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + status);
        Thread.sleep(((int) (Math.random() * 100)));
    }
}
