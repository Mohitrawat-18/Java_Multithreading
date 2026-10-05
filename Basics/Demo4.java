package Basics;

public class Demo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 is running...");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread-2 is running...");
        });

        // t2.setPriority(10);
        // t1.start();
        // t2.start();

        Thread t3 = new Thread(() -> {
            while (true) {
                System.out.println("Running...");
            }
        });

        t3.setDaemon(true); // Daemon Thread
        t3.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

}

/*
 * Thread Priority
 * MAX_PRIORITY = 10
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5
 */

// Daemon Threads