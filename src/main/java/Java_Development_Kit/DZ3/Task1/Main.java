package Java_Development_Kit.DZ3.Task1;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        var intSumResult = calculator.sum(1111.1, 333);
        var intSubtractResult = calculator.subtract(100, 10.1);
        var doubleMultiplyResult = calculator.multiply(137, 0.5);
        var doubleDivideResult = calculator.divide(254, 7000);
        var doubleDivideResult2 = calculator.divide(254.0, 7000);

        System.out.println("Сумма: " + intSumResult);
        System.out.println("Разность: " + intSubtractResult);
        System.out.println("Произведение: " + doubleMultiplyResult);
        System.out.println("Деление целочисленное: " + doubleDivideResult);
        System.out.println("Деление дробное: " + doubleDivideResult2);
    }
}
