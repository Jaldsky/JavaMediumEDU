import java.util.Scanner;

public class Lesson16 {
    public static void main(String[] args) {
        MyThread2 myThread1 = new MyThread2();
        myThread1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); //ждем пока не придет строка

        myThread1.shutdown(); //отключение
    }
}
class MyThread2 extends Thread{
    private volatile boolean running = true; //флаг активности

    public void run(){
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        this.running = false;
    }
}
