import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson23 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3); //указываем количество операций назад прежде чем зашелка разблокируется

        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i =0; i<3; i++){
            es.submit(new Processor(i, cdl));
        }
        es.shutdown();

        for (int i=0; i<3; i++){
            Thread.sleep(1000);
            cdl.countDown();
        }

        }
}


class Processor implements Runnable{
    private int id;
    private CountDownLatch cdl;

    public Processor(int id, CountDownLatch cdl){
        this.id = id;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id: " + id + " proceeded");


    }
}
