package Lesson38;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        //НазваниеКласса1 НазваниеКласса2 НазваниеМетода

        Class classObject1 =Class.forName(scanner.next());
        Class classObject2 =Class.forName(scanner.next());
        String methodName = scanner.next();

        Method method = classObject1.getMethod(methodName, classObject2);
        Object object1 = classObject1.newInstance();
        Object object2 = classObject1.getConstructor(String.class).newInstance("String value");

        method.invoke(object1, object2);
        System.out.println(object1);
    }
}
