package Java_Core.Seminar4.Models;

import Java_Core.Seminar4.Exceptions.OutOfBoundsExeption;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Database implements Iterable<BankAccount> {
    private static ArrayList<BankAccount> bankAccounts;

    public Database() {
        bankAccounts = new ArrayList<>();
    }

    public void addBankAccount(String name, Double balance, Database database){
        bankAccounts.add(new BankAccount(name, balance, database));
    }
    public void addCreditAccount(String name, Double balance, Database database){
        bankAccounts.add(new CreditBankAccount(name, balance, database));
    }
    public void addDebitAccount(String name, Double balance, Database database){
        bankAccounts.add(new DebitBankAccount(name, balance, database));
    }

    public int dataBaseSize(){
        return bankAccounts.size();
    }

    @Override
    public Iterator<BankAccount> iterator() {
        Iterator<BankAccount> iterator = new Iterator<>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() { return currentIndex < bankAccounts.size(); }

            @Override
            public BankAccount next() {
                if(hasNext()){ return bankAccounts.get(currentIndex++); }
                else try {
                    System.out.println("Число элементов базе данных: " + bankAccounts.size() + 1);
                    throw new OutOfBoundsExeption("Вы вышли за пределы базы данных! Текущий индекс : ", currentIndex);
                } catch (OutOfBoundsExeption e) {
                    throw new RuntimeException(e);
                }
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super BankAccount> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<BankAccount> spliterator() {
        return Iterable.super.spliterator();
    }

    public void printDB(){
        for (BankAccount bankAccount: bankAccounts) {
            bankAccount.printBA();
        }
    }

    public BankAccount searchBankAccount(int id) throws OutOfBoundsExeption {
        for (BankAccount bankAccount: bankAccounts) {
            if(bankAccount.getId() == id) return bankAccount;
        }
        throw new OutOfBoundsExeption("Счета с таким номером не существует", id);
    }


}
