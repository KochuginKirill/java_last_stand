package Java_Development_Kit.DZ3.Task3;

public class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
