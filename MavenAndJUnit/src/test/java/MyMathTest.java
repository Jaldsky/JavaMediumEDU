import org.junit.Test;

public class MyMathTest {
    @Test (expected = ArithmeticException.class) //ожидаем что будет выбражено исключение ArithmeticException
    public void zeroDenominatorShouldThrowException(){
        MyMath.divided(1, 0);

    }
}
