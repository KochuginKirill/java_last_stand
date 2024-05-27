package Java_Development_Kit.DZ3.Task3;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(435, "String");
        Pair<Double, Integer> pair2 = new Pair<>(777.777, 666);

        System.out.println("Пара1: " + pair1);
        System.out.println("Первое значение пары 2: " + pair2.getFirst());
        System.out.println("Второе значение пары 2: " + pair2.getSecond());
    }
}
