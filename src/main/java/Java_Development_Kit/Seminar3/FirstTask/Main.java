package Java_Development_Kit.Seminar3.FirstTask;

import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        Task1<String, DataInputStream, Integer> task1 = new Task1<>("Текст", new DataInputStream(System.in), 9);
        task1.printTask1();
    }
}
