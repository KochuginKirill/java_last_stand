package Java_Core.Seminar4.Models;

public class CreditBankAccount extends BankAccount{

    CreditBankAccount(String name, Double balance, Database database) throws IllegalArgumentException {
        super(name, balance, database);
        this.accountType = "CreditAccount";
    }

}
