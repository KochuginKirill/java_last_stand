package Java_Development_Kit.Seminar3.FirstTask;
//Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три перемен-
//ные типа (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K), методы
//
//возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
//
//классов для трех переменных класса. Наложить ограничения на параметры типа: T дол-
//жен реализовать интерфейс Comparable (классы оболочки, String), V должен реализо-
//вать интерфейс DataInput и расширять класс InputStream, K должен расширять класс
//
//Number.

import java.io.DataInput;
import java.io.InputStream;

public class Task1<T extends Comparable<String>, V extends InputStream & DataInput, K extends Number> {
    T t;
    V v;
    K k;

    public Task1(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printTask1(){
        System.out.printf("T: %s, V: %s, K: %s",
                t.getClass().getName(), v.getClass().getName(), k.getClass().getName());
    }
}
