class Lesson17 {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        Lesson17 test = new Lesson17();
        test.doWork();
    }

    public void increment(){
        synchronized (this) {
            counter++;
        }//все что в теле метода может выполнять только один поток,
        // не может быть такого, чтобы два потока одновременно выполняли тело метода
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++)
                    increment();

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++)
                    increment();

            }
        });
        thread1.start();
        thread2.start();

        thread1.join(); //позволяет подождать, пока поток не выполнится
        thread2.join();

        System.out.println(counter);
    }
}

