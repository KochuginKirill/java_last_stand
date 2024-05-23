package Java_Development_Kit.Seminar3.SecondTask;

import java.util.Iterator;

public class CollectionEx<T> implements Iterable<T> {

    private static final int DEFAULT_SIZE = 10;
    int size = 0;

    Object[] array;

    public CollectionEx() {
        array = new Object[DEFAULT_SIZE];
    }

    public void add(T t){
        if(size == array.length){
            Object[] newArray = new Object[array.length + DEFAULT_SIZE];
            System.arraycopy(array, 0, newArray, 0, array.length);
        }
        array[size++] = t;
    }

    public void delete(int index){
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this) {
            sb.append(t + " ");
        }
        return "CollectionEx {" +
                "size= " + size +
                "array= " + "[" + sb + "]" +
                '}';
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index] == null ? null : (T) array[index++];
            }
        };
    }
}
