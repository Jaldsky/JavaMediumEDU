import java.util.concurrent.*;

public class Lesson25 {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(3); //семафор с количеством разрешений для потоков, сколько потоков могут работать одновременно
//
//        semaphore.acquire(); //берем разрешение
//        semaphore.acquire();
//        semaphore.acquire();
//
//        System.out.println("All permits have been acquired!");
//        semaphore.acquire();
//
//        System.out.println("Can't reach here...");
//
//        //потоки должны брать, а потом отдавать разрешение на использование семафора
//        semaphore.release(); //отдает одно из разрешений
//
//        System.out.println(semaphore.availablePermits());//количество разрешений
//


        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();


        for (int i=0; i<200; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
 }
}
class Connection{ //реализация синглтона, возможно создать только один класс Conntection
    private static Connection connection = new Connection();
    private int connectionCounts;

    private Semaphore semaphore = new Semaphore(10);

    private Connection(){

    }

    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        //чтобы не возникло в методе doWork, метод всеравно должен вернуть разрешение
        //конструкция ниже позволяет это сделать
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this){
            connectionCounts++;
            System.out.println(connectionCounts);
        }
        Thread.sleep(5000); //какая-то полезная работа

        synchronized (this){
            connectionCounts--;
        }


    }
}
