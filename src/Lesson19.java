import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lesson19 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2); //пул потоков из двух потоков

        for (int i=0; i<5; i++)
            executorService.submit(new Work(i)); //передача заданий для потоков
            executorService.shutdown(); //метод говорит что передача закончена

            System.out.println("All tasks submitted");

            executorService.awaitTermination(1, TimeUnit.DAYS); //метод который задает количество времени
            //пока потоки выполняются, если по истечению времени потоки так и не отработали,то
            //потоки прерываются и программа продолжает свое выполнение дальше

    }
}
class Work implements Runnable{
    private int id;

    public Work(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " was completed");
    }


}
