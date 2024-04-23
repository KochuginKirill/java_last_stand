package Java_Core.Seminar3;

import java.util.ArrayList;
import java.util.Collections;

public class WorkerDB {
    ArrayList<Worker> workers;

    void sortWorkers(){
        Collections.sort(workers);
    }

    void addWorkers(Worker worker) {
        workers.add(worker);
    }

    ArrayList<Worker> getWorkers() {
        return workers;
    }

    public WorkerDB() {
        this.workers = new ArrayList<>();
    }
}
