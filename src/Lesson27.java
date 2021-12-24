import java.util.Random;

public class Lesson27 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i=0; i<1_000_000_000; i++){
                    if (Thread.currentThread().isInterrupted()) { //конструкция говорит методу, что его возможно будет прервать
                        System.out.println("Thread was interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());

                }
            }
        });
        System.out.println("Starting thread");

        thread.start();


        Thread.sleep(1000);
        thread.interrupt(); //если вызовем этот метод, то поток прервется

        thread.join(); //join стоит всегда в конце после interrupt

        System.out.println("Thread has finished");
    }
}
