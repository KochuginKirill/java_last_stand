package Java_Core.Seminar4.Models;

public class DebitBankAccount extends BankAccount{
    DebitBankAccount(String name, Double balance, Database database) throws IllegalArgumentException {
        super(name, balance, database);
    }
}
