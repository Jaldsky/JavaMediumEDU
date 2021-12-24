public class Lesson29 {
    public static void main(String[] args) {
        /*

        \\d - одна цифра, эквивалентно записи [0-9]
        \\w - одна буква, эквивалентно записи [A-Za-z]

        \\ - экранирование
        + - 1 или более
        * - 0 или более
        ? - 0 или 1 символов до, символ может быть или не быть
        (x|y|z) - одна строка из сможества строк
        [A-Za-z] - множество букв, например [abc] == (a|b|c)
        [^abc] - отрицание, все символы, кроме a b c
        . - любой символ

        {2} - точное количество предыдущих символов, два символа до
        {2,} - два и более символа
        {2,5} - от двух до пяти символов


         */
        String string1 = "1234";
        System.out.println("string1 " + string1.matches("1234"));
        //сравнивает строку на которой вызывается и той строкой, которая приходит на вход
        //matches также принимает помимо строки регулярные выражения

        String string2 = "123"; //1, 2, 3, 4, 5, 6, 7, 8, 9 - любая цифра в еденичном экземпляре
        System.out.println("string2 " + string2.matches("\\d+"));

        String string3 = ""; //даже ничего является 0
        System.out.println("string3 " + string3.matches("\\d*"));

        System.out.println("\n");

        String string4 = "-2450"; //числа с минусом -
        String string5 = "2450"; //минус может быть или может не быть -?
        String string6 = "+2450"; //числа с плюсом, (+|-)? может быть плюс или минус
        System.out.println("string4 -\\\\d* " + string4.matches("-\\d*") + " string4 -?\\\\d* " + string4.matches("-?\\d*") + " string4 (\\\\+|-)?\\\\d* " + string4.matches("(\\+|-)?\\d*"));
        System.out.println("string5 -\\\\d* " + string5.matches("-\\d*") + " string5 -?\\\\d* " + string5.matches("-?\\d*") + " string5 (\\\\+|-)?\\\\d* " + string5.matches("(\\+|-)?\\d*"));
        System.out.println("string6 -\\\\d* " + string6.matches("-\\d*") + " string6 -?\\\\d* " + string6.matches("-?\\d*") + " string6 (\\\\+|-)?\\\\d* " + string6.matches("(\\+|-)?\\d*"));

        System.out.println("\n");

        String string7 = "D-2450"; //один символ из английского алфавита [A-Za-z]
        String string8 = "RFeeD-2450"; //множество символов из английского алфавита [A-Za-z]+
        String string9 = "R7F5e5e7D-2450"; //множество символов из английского алфавита а также числа 5 и 7 [A-Za-z57]+
        System.out.println("string7 [A-Za-z](\\\\+|-)\\\\d* " + string7.matches("[A-Za-z](\\+|-)\\d*") + " string7 [A-Za-z]+(\\\\+|-)\\\\d* " + string7.matches("[A-Za-z]+(\\+|-)\\d*") + " string7 [A-Za-z57]+(\\\\+|-)\\\\d* " + string7.matches("[A-Za-z57]+(\\+|-)\\d*"));
        System.out.println("string8 [A-Za-z](\\\\+|-)\\\\d* " + string8.matches("[A-Za-z](\\+|-)\\d*") + " string8 [A-Za-z]+(\\\\+|-)\\\\d* " + string8.matches("[A-Za-z]+(\\+|-)\\d*") + " string8 [A-Za-z57]+(\\\\+|-)\\\\d* " + string8.matches("[A-Za-z57]+(\\+|-)\\d*"));
        System.out.println("string9 [A-Za-z](\\\\+|-)\\\\d* " + string9.matches("[A-Za-z](\\+|-)\\d*") + " string9 [A-Za-z]+(\\\\+|-)\\\\d* " + string9.matches("[A-Za-z]+(\\+|-)\\d*") + " string9 [A-Za-z57]+(\\\\+|-)\\\\d* " + string9.matches("[A-Za-z57]+(\\+|-)\\d*"));

        System.out.println("\n");

        String string10 = "agetRgdf634f"; //все символы, кроме a b c
        String string11 = "getRgdf634f";
        System.out.println("string10 " + string10.matches("[^abc]*") + " string11 " + string11.matches("[^abc]*"));

        System.out.println("\n");

        String string12 = "http://www.google.com";
        String string13 = "http://www.yandex.ru";
        System.out.println("string12 " + string12.matches("http://www\\..+\\.(com|ru)"));
        System.out.println("string13 " + string13.matches("http://www\\..+\\.(com|ru)"));

        System.out.println("\n");

        String string14 = "123";
        String string15 = "1236456";
        String string16 = "1236";

        System.out.println("string14 \\\\d{3} " + string14.matches("\\d{3}") + " string14 \\\\d{2,}" + string14.matches("\\d{2,}") + " string14 \\\\d{1,4}" + string14.matches("\\d{1,4}"));
        System.out.println("string15 \\\\d{3} " + string15.matches("\\d{3}") + " string15 \\\\d{2,}" + string15.matches("\\d{2,}") + " string15 \\\\d{1,4}" + string15.matches("\\d{1,4}"));
        System.out.println("string16 \\\\d{3} " + string16.matches("\\d{3}") + " string16 \\\\d{2,}" + string16.matches("\\d{2,}") + " string16 \\\\d{1,4}" + string16.matches("\\d{1,4}"));
    }

}
