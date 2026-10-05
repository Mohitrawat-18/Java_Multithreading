package Basics;

public class Demo2 {
    public static void main(String[] args) {

        // Thread Lifecycle
        Thread mainThread = Thread.currentThread();

        // Thread new stage
        Thread t1 = new Thread(() -> {
            System.out.println("Name of current thread : " + Thread.currentThread().getName());
            System.out.println("Main thread state : " + mainThread.getState()); // TIMED_WAITING
        });

        System.out.println(t1.getState()); // NEW

        // Runnable stage
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        System.out.println(t1.getState()); // TERMINATED
    }
}
