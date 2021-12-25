import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson31 {
    public static void main(String[] args) {
        String text = "Hooe rrooe giess ioef jooke ijge fooie booie \n" +
                "jihi rood jsk ejf fsk fooek iooed@gmail.com \n" +
                "an oriefk dkeh yotooed@mail.ru fjjiees ioke judm";

        Pattern email = Pattern.compile("\\w+@(gmail|mail)\\.(com|ru)"); //паттерн программирования фактори метод
        Matcher matcher = email.matcher(text);

        while (matcher.find()){ //find возвращает true, если что-то нашел удовлеторяющее условию
            System.out.println(matcher.group()); //group возвращает то, что было найдено методом find
        }

    }

}
