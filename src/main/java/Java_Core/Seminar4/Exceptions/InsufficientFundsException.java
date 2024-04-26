package Java_Core.Seminar4.Exceptions;

public class InsufficientFundsException extends Exception {
    double input;
    double balance;

    public InsufficientFundsException(String message, double input, double balance) {
        super(message);
        this.input = input;
        this.balance = balance;
    }
}
