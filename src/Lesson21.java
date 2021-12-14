import java.util.Scanner;

class Lesson21 {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wan = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wan.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wan.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this) { //синхронизируемся на исходном объекте т.е. на new WaitAndNotify();
            System.out.println("Producer method started...");
            wait(); //может вызываться только в пределеах синхронизованного блока
            //вызывается на том синхронизированном блоке который определен т. е. на new WaitAndNotify();
            //при выполнении метод отдает intrinsic lock т. е. как-будто вышли из синхронизированного блока
            //при вызову wait всегда ждем пока будет вызван метод notify
            System.out.println("Producer thread resumed...");

        }
    }
    public void consume() throws InterruptedException {
        Thread.sleep(2000);

        Scanner scanner = new Scanner(System.in);
        synchronized (this) {
            System.out.println("Waiting for returned key pressed");
            scanner.nextLine();
            notifyAll(); //все потоки которые ждут сразу же проснуться

            Thread.sleep(5000); //монитор вернется только через 5 секунд дургому потоку
        }

    }
}
