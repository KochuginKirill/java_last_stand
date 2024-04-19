package Java_Core.Seminar1.services;

import java.io.BufferedReader;
import java.util.Scanner;

public class Services {
    /**
     * Transforms all symbols in different case
     * @param string
     * @return
     */
    public static String toAlternativeString(String string) {
        String result = "";
        for (char c : string.toCharArray()) {
            if(Character.isUpperCase(c)) {
                result += Character.toLowerCase(c);
            } else {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }

    /**
     * Возвращает пользователю строку с буквами в противоположном регистре (А - а)
     */
    public static void toAlternativeInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Напишите строку => ");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println(toAlternativeString(input));
    }
}
