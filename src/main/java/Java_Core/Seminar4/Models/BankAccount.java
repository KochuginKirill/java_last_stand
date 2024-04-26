package Java_Core.Seminar4.Models;

import Java_Core.Seminar4.Exceptions.InsufficientFundsException;


public class BankAccount {
    private int id;
    private String name;
    private Double balance;

    BankAccount(String name, Double balance, Database database) throws IllegalArgumentException {
        if (balance >= 0){
            this.id = database.dataBaseSize() + 1;
            this.name = name;
            this.balance = balance;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void printBA(){
        System.out.println();
        System.out.println("--------------");
        System.out.println("id: " + id);
        System.out.println("Имя: " + name );
        System.out.println("Баланс: " + balance);
        System.out.println("--------------");
        System.out.println();
    }

    public void addToBalance(double input) throws IllegalArgumentException {
        if(input > 0){
            balance = balance + input;
        } else {
            System.out.println("Вы не можете добавить " + input + " на ваш счет");
            throw new IllegalArgumentException();
        }
    }

    public void withdrawFromBalance(double input) throws InsufficientFundsException {
        if(input > 0 && input <= balance){
            balance = balance - input;
        } else {
            throw new InsufficientFundsException("Вы не можете снять данную сумму, недостаточно средств", input, balance);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }
}
