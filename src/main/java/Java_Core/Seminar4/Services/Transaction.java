package Java_Core.Seminar4.Services;

import Java_Core.Seminar4.Exceptions.InsufficientFundsException;
import Java_Core.Seminar4.Exceptions.OutOfBoundsExeption;
import Java_Core.Seminar4.Exceptions.TransactionError;
import Java_Core.Seminar4.Models.BankAccount;
import Java_Core.Seminar4.Models.Database;

import static Java_Core.Seminar4.Services.UserInputs.userInputDouble;
import static Java_Core.Seminar4.Services.UserInputs.userInputInteger;

public class Transaction {
    public static void BankAccountTransfer(Database database) throws TransactionError {
        int id1;
        int id2;
        Double sum;
        System.out.println("---------------------------------------------------------");
        System.out.print("Напишите номер (id) счета с коготорого нужно перевести деньги => ");
        id1 = userInputInteger();
        System.out.println("---------------------------------------------------------");
        System.out.print("Напишите номер (id) счета куда нужно перевести деньги => ");
        id2 = userInputInteger();
        System.out.println();
        System.out.println("---------------------------------------------------------");
        System.out.print("Напишите сумму для перевода => ");
        sum = userInputDouble();
        System.out.println();
        try {
            if(sum <= database.searchBankAccount(id1).getBalance() && sum > 0){
                database.searchBankAccount(id1).withdrawFromBalance(sum);
                database.searchBankAccount(id2).addToBalance(sum);
            }else {
                System.out.println("Текущий баланс счета доступный для снятия: " + database.searchBankAccount(id1).getBalance());
                System.out.println("Сумма, которую вы хотите снять: " + sum);
                throw new TransactionError("Произошла ошибка перевода, перепроверьте данные");
            }
        } catch (OutOfBoundsExeption | InsufficientFundsException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
