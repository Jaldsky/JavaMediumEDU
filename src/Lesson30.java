import java.util.Arrays;

public class Lesson30 {
    public static void main(String[] args) {
        //split принимает на вход регулярные выражения и разбивает строку по этому регулярному выражению

        String string1 = "Hello11233322hay0094337there";
        String[] words = string1.split("\\d+");
        System.out.println(Arrays.toString(words));

        //метод replace принимает только строку
        //метод replaceAll принимает регулярное выражение
        String string2 = "Hello321hay23552there";
        String result1 = string2.replaceAll("\\d+", "/");
        String result2 = string2.replaceFirst("\\d+", "/");
        System.out.println(result1);
        System.out.println(result2);

    }
}
