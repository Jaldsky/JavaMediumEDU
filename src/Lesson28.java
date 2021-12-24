import java.util.Random;
import java.util.concurrent.*;

public class Lesson28 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(new Callable<Integer>() { //с помощью интерфейса Callable в отличие от Runnable можно возвращать значения
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                int randomValue = random.nextInt();
                if (randomValue < 5)
                    throw new Exception("Error");

                return random.nextInt(10); // можем вернуть значение
            }
        });
        executorService.shutdown();

        try {
            int result = future.get(); //get ожидает выполнение потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
