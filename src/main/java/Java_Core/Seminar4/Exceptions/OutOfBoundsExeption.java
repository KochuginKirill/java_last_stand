package Java_Core.Seminar4.Exceptions;

public class OutOfBoundsExeption extends Exception{
    int index;

    public OutOfBoundsExeption(String message, int index) {
        super(message);
        this.index = index;
    }
}
