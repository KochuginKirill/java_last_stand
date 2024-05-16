package Java_Core;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int x = 0;
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите целое число => ");
            x = Integer.parseInt(scanner.nextLine());
            System.out.println();
            System.out.println("Число: " + x);
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        System.out.println("Число: " + x);
    }
}
