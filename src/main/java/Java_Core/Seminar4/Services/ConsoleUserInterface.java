package Java_Core.Seminar4.Services;

import Java_Core.Seminar4.Exceptions.InsufficientFundsException;
import Java_Core.Seminar4.Exceptions.OutOfBoundsExeption;
import Java_Core.Seminar4.Exceptions.TransactionError;
import Java_Core.Seminar4.Models.Database;

import static Java_Core.Seminar4.Services.Transaction.BankAccountTransfer;
import static Java_Core.Seminar4.Services.UserInputs.*;

public class ConsoleUserInterface {
    public static void runProgram(){
        Database database = new Database();
        database.addBankAccount("Petya", 10000.0, database);
        database.addCreditAccount("Kolya", 30000.0, database);
        database.addDebitAccount("Masha", 150000.0, database);
        int input1 ;
        Double input2;
        String input3;
        while (true){
            input1 = 0;
            input2 = 0.0;
            input3 = "";
            System.out.println("----------------------------");
            System.out.println("1) Напечатать все текущие счета");
            System.out.println("2) Напечатать конкретный счет");
            System.out.println("3) Добавить деньги на конкретный счет");
            System.out.println("4) Снять деньги с конкретного счета");
            System.out.println("5) Открыть новый счет");
            System.out.println("6) Открыть новый кредитный счет");
            System.out.println("7) Открыть новый дебетовый счет");
            System.out.println("8) Перевести деньги с счета на счет");
            System.out.println("0) Закрыть программу");
            System.out.println("----------------------------");
            System.out.println();
            System.out.print("Напишите цифру запроса => ");
            input1 = userInputInteger();
            if (input1 < 0 || input1 > 8){
                continue;
            }
            switch(input1){
                case 1:
                    database.printDB();
                    break;
                case 2:
                    System.out.println("----------------------------");
                    System.out.print("Напишите номер (id) нужного вам счета => ");
                    input1 = userInputInteger();
                    System.out.println();
                    try {
                        database.searchBankAccount(input1).printBA();
                    } catch (OutOfBoundsExeption e) {
                       e.printStackTrace();
                       throw new RuntimeException();
                    }
                    break;
                case 3:
                    System.out.println("----------------------------");
                    System.out.print("Напишите номер (id) счета для пополнения => ");
                    input1 = userInputInteger();
                    System.out.println();
                    System.out.print("Введите сумму => ");
                    input2 = userInputDouble();
                    System.out.println();
                    try {
                        database.searchBankAccount(input1).addToBalance(input2);
                    } catch (IllegalArgumentException | OutOfBoundsExeption e) {
                        e.printStackTrace();
                        throw new RuntimeException();
                    }
                    break;
                case 4:
                    System.out.println("----------------------------");
                    System.out.print("Напишите номер (id) счета для снятия => ");
                    input1 = userInputInteger();
                    System.out.println();
                    System.out.print("Введите сумму => ");
                    input2 = userInputDouble();
                    System.out.println();
                    try {
                        database.searchBankAccount(input1).withdrawFromBalance(input2);
                    } catch (OutOfBoundsExeption | InsufficientFundsException e) {
                        e.printStackTrace();
                        throw new RuntimeException();
                    }
                    break;
                case 5:
                    System.out.println("----------------------------");
                    System.out.print("Введите название нового счета =>");
                    input3 = userInputString();
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.print("Внесите начальную сумму =>");
                    input2 = userInputDouble();
                    System.out.println();
                    database.addBankAccount(input3, input2, database);
                    break;
                case 6:
                    System.out.println("----------------------------");
                    System.out.print("Введите название нового кредитного счета =>");
                    input3 = userInputString();
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.print("Внесите начальную сумму =>");
                    input2 = userInputDouble();
                    System.out.println();
                    database.addCreditAccount(input3, input2, database);
                    break;
                case 7:
                    System.out.println("----------------------------");
                    System.out.print("Введите название нового дебетового счета =>");
                    input3 = userInputString();
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.print("Внесите начальную сумму =>");
                    input2 = userInputDouble();
                    System.out.println();
                    database.addDebitAccount(input3, input2, database);
                    break;
                case 8:
                    try {
                        BankAccountTransfer(database);
                    } catch (TransactionError e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                    break;
                case 0:
                    System.out.println("До свидания!");
                    System.exit(0);
            }

        }
    }
}
