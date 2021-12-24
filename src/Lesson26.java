import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lesson26 {
    public static void main(String[] args) throws InterruptedException {
        Runner1 runner = new Runner1();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread((new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();

    }
}
class Runner1{
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void firstThread() throws InterruptedException{
        Random random = new Random();

        for (int i=0; i<10000; i++) {
//            //использование локов
//            //ситуация с дедлоками
//            lock1.lock(); //1. первый взят, остался второй лок
//
//            lock2.lock(); //3. требуется второй лок, но его уже взял другой поток
//            //так и выглядит ситуация с дедлоком

            takeLocks(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }

//        for (int i=0; i<10000; i++) {
//            synchronized (account1) { //должны быть получены экраны с account1, account2
//                synchronized (account2) { //для избежания вложености используются локи
//                    Account.transfer(account1, account2, random.nextInt(100));
//                }
//            }
//        }
    }

    private void takeLocks(Lock lock1, Lock lock2) throws InterruptedException {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
        try {
            firstLockTaken = lock1.tryLock();
            secondLockTaken = lock2.tryLock();
        } finally {
            if (firstLockTaken && secondLockTaken == true) {
                return;
            }
            if (firstLockTaken) {
                lock1.unlock();
            }
            if (secondLockTaken) {
                lock2.unlock();
            }
        }
        Thread.sleep(1);
        }
    }

    public void secondThread() throws InterruptedException{
        Random random = new Random();

        for (int i=0; i<10000; i++) {
//            lock2.lock(); //2. первый и второй лок взят
//
//            lock1.lock(); //4. требуется первый лок, но его уже взял другой поток

            takeLocks(lock2, lock1);
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock(); //анлок в любом случае должен выполниться
                lock2.unlock();
            }
        }

    }

    public void finished(){
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance is " + (account1.getBalance()+ account2.getBalance()));

    }

}
class Account{
    private int balance = 10000;

    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
    public int getBalance(){
        return balance;
    }
    public static void transfer(Account acc1, Account acc2, int amount){
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}