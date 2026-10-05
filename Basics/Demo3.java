package Basics;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts..");

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("Thread-0 starts..");
        });

        // t1.start();
        // t1.join();

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("T2 : " + i);
                Thread.yield();
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("T3 : " + i);
            }
        });

        // t2.start();
        // t3.start();

        // try {
        // Thread.sleep(2000);
        // } catch (Exception e) {
        // }

        Thread t4 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Running..");
            }
        });

        t4.start();
        t4.interrupt();

        System.out.println("Main thread ends");
    }
}

// currentThread()
// Thread.sleep(millis)
// join()
// yield()
// interrupt()
// interrupted()
// isInterrupted()
// isAlive()