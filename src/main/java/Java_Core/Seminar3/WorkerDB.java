package Java_Core.Seminar3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class WorkerDB implements Iterable<Worker>{
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

    @Override
    public Iterator<Worker> iterator() {
        Iterator<Worker> iterator = new Iterator<Worker>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < workers.size();
            }

            @Override
            public Worker next() {
                if (hasNext()) return workers.get(currentIndex++);
                else throw new UnsupportedOperationException("Ошибка!");
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super Worker> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Worker> spliterator() {
        return Iterable.super.spliterator();
    }
}
