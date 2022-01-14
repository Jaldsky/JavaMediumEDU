import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Vector2DTest {
    private final double EPS = 1e-9;
    private static Vector2D v1;

//    @Before //так
//    public void createNewVectror2D(){
//        v1 = new Vector2D();
//
//    }

    @BeforeClass //или так
    public static void createNewVectror2D(){
        v1 = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveLenght(){
//        Vector2D v1 = new Vector2D(); //action //метод уже создан в @Before методе createNewVectror2D

        //assertion
        Assert.assertEquals(0, v1.length(), EPS);
        // первый парамметр ожидаемый результат, второй парамметр фактический,
        // третий точность первого и второго аргументов
    }
//    @Test //так
//    public void newVectorShouldHaveZeroX(){
////        Vector2D v1 = new Vector2D();
//        Assert.assertEquals(0, v1.getX(), EPS);
//    }
//    @Test
//    public void newVectorShouldHaveZeroY(){
////        Vector2D v1 = new Vector2D();
//        Assert.assertEquals(0, v1.getY(), EPS);
//    }
    @Test //или так, но следует помнить, что если методы сложны, то их лучше тестировать по отдельности
    public void newVectorShouldHaveZeroXandY(){
        Assert.assertEquals(0, v1.getX(), EPS);
        Assert.assertEquals(0, v1.getY(), EPS);
    }
}
