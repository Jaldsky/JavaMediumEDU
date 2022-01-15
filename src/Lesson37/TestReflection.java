package Lesson37;

import java.lang.annotation.Annotation;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        Class personClass1 = person.getClass(); //первый способ
        Class personClass2 = Person.class; //второй способ
//        Class personClass3 = Class.forName("Person"); //третий способ, указываем полный путь
//
//        Method[] methods = personClass1.getMethods();
//        for (Method method: methods){
//            System.out.println(method.getName() + " , " + method.getReturnType() + " , " + Arrays.toString(method.getParameterTypes()));
//        }

//        Field[] fields = personClass1.getDeclaredFields();
//        for (Field field: fields){
//            System.out.println(field.getName() + " , " + field.getType());
//        }

        Annotation[] annotations = personClass1.getAnnotations();
        for (Annotation annotation: annotations){
           if (annotation instanceof Author){
               System.out.println("Yes");
           }
        }
    }
}
