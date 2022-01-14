package Lesson35;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //анотацию можно использовать только для метода
@Retention(RetentionPolicy.RUNTIME) //анотация доступна во время выполнения программы
public @interface MethodInfo {
    String author() default "Bob";
    int dateOfCreation() default 2007;
    String purpose();
}
