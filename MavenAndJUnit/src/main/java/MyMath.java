public class MyMath {
    public static double divided(int number1, int number2){
        if (number2 == 0)
            throw new ArithmeticException("Can't divided by zero");

        return number1 / number2;
    }
}
