interface Executable{
    int execute(int x, int y);
}

class Runner2{
    public void run(Executable e){
        int a = e.execute(10, 5);
        System.out.println(a);
    }
}

class ExecutableImplementation implements Executable{ //первый способ
    @Override
    public int execute(int x, int y) {
        System.out.println("Hello");
        return x + y;
    }
}

public class Lesson32 {
    public static void main(String[] args) {
        Runner2 runner = new Runner2();

        runner.run(new ExecutableImplementation()); //первый способ

        runner.run(new Executable() { //второй способ
            @Override
            public int execute(int x, int y) {
                System.out.println("Hello");
                return x + y;
            }
        });

        //третий способ с использованием лямбда-выражения
        final int b = 5; //число не должно меняться, для того, чтобы можно было работать с лямбдо-выражением
        runner.run((x, y) -> x + y + b); //так

        runner.run((int x, int y) -> { //или так
            System.out.println("Hello");
            return x + y + b;
        });

//        runner.run(x -> x); //так
        /*
без использования лямбда-выражени
        Thread thread = new Thread(new Runnable() {//анонимный класс,
        который реализует интерфейс Runnable и метод run()
            @Override
            public void run() {
                System.out.println("Hello");
            }
        });
с использованием лямбда-выражения
        Thread thread = new Thread(() -> {
        System.out.println("Hello");
        System.out.println("Hi");
        });  //не принимает на вход никаких аргументов

*/

    }
}
