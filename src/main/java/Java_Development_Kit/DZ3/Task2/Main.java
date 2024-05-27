package Java_Development_Kit.DZ3.Task2;

public class Main {
    public static void main(String[] args) {
        ArrayComparator arrayComparator = new ArrayComparator();
        Integer[] Array1 = {1, 2, 3};
        Integer[] Array2 = {1, 2, 3};
        Integer[] Array3 = {1, 2, 4};
        Double[] Array4 = {1.0, 2.0, 3.0};
        String[] Array5 = {"String1", "String2", "String3"};
        String[] Array6 = {"String1", "String2", "String3"};
        String[] Array7 = {"String1", "String2", "String4"};
        String[] Array8 = {"String1", "String2"};

        boolean result1 = arrayComparator.compareTwoArrays(Array1, Array2);
        boolean result2 = arrayComparator.compareTwoArrays(Array5, Array6);
        boolean result3 = arrayComparator.compareTwoArrays(Array4, Array1);
        boolean result4 = arrayComparator.compareTwoArrays(Array1, Array3);
        boolean result5 = arrayComparator.compareTwoArrays(Array5, Array7);
        boolean result6 = arrayComparator.compareTwoArrays(Array7, Array8);

        System.out.println("Array1 = Array2:" + result1);
        System.out.println("Array5 = Array6: " + result2);
        System.out.println("Array4 = Array1: " + result3);
        System.out.println("Array1 = Array3: " + result4);
        System.out.println("Array5 = Array7: " + result5);
        System.out.println("Array7 = Array8: " + result6);
    }
}
