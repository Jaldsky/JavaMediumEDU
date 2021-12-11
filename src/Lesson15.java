public class Lesson15 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        myThread1.start(); //вызываем нашпоток

        MyThread myThread2 = new MyThread();
        myThread2.start();

        System.out.println("I'm going to sleep");
        Thread.sleep(1000); //поток засыпает
        System.out.println("I'm awake!");

        Thread myThread3 = new Thread(new Runner());
        myThread3.start();
    }
}
class Runner implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            System.out.println("Thread " + i);
        }
    }
}

class MyThread extends Thread{
    public void run(){ //здесь описываем код, который будет выполняться в потоке
        for (int i=0; i<1000; i++){
            System.out.println("Hello from Thread" + i);
        }

    }
}
