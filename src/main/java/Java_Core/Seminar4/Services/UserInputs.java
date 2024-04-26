package Java_Core.Seminar4.Services;

import java.util.Scanner;

public class UserInputs {
    public static int userInputInteger(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String userInputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Double userInputDouble(){
        Scanner scanner = new Scanner(System.in);
        return Double.parseDouble(scanner.nextLine());
    }
}
