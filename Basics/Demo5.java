package Basics;

public class Demo5 {

    // volatile keyword -> to resolve the visibility problem.
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            flag = true;
        });

        Thread t2 = new Thread(() -> {
            while (!flag) {
                // System.out.println("Thread 2 running.."); // synchronized
                // do nothing
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();
    }
}
