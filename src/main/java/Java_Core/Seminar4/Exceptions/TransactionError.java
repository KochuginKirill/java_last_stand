package Java_Core.Seminar4.Exceptions;

public class TransactionError extends Exception{
    public TransactionError(String message) {
        super(message);
    }
}
