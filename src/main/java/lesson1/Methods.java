package lesson1;

public class Methods {
    /**
     *строку с измененным регистром букв
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
}
