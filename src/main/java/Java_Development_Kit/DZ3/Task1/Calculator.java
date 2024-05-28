package Java_Development_Kit.DZ3.Task1;

public class Calculator {

    public <T extends Number> T sum(T number1, T number2) {
        if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf(number1.intValue() + number2.intValue());
        } else if (number1 instanceof Double || number2 instanceof Double) {
            return (T) Double.valueOf(number1.doubleValue() + number2.doubleValue());
        } else {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
    }

    public <T extends Number> T subtract(T number1, T number2) {
        if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf(number1.intValue() - number2.intValue());
        } else if (number1 instanceof Double || number2 instanceof Double) {
            return (T) Double.valueOf(number1.doubleValue() - number2.doubleValue());
        } else {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
    }

    public <T extends Number> T multiply(T number1, T number2) {
        if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf(number1.intValue() * number2.intValue());
        } else if (number1 instanceof Double || number2 instanceof Double) {
            return (T) Double.valueOf(number1.doubleValue() * number2.doubleValue());
        } else {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
    }

    public <T extends Number> T divide(T number1, T number2) {
        if (number1 instanceof Integer & number2 instanceof Integer) {
            return (T) Integer.valueOf(number1.intValue() / number2.intValue());
        } else if (number1 instanceof Double || number2 instanceof Double) {
            return (T) Double.valueOf(number1.doubleValue() / number2.doubleValue());
        } else {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
    }
}
