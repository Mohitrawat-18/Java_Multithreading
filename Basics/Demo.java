package Basics;

public class Demo {
    public static void main(String[] args) {
        // MyThread t1 = new MyThread();
        // t1.start();

        // MyRunnable r1 = new MyRunnable();
        // Thread t1 = new Thread(r1);
        // t1.start();

        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getName());
        });
        t1.start();
    }
}

// class MyThread extends Thread {
// @Override
// public void run() {
// System.out.println("Thread is running...");
// }
// }

// class MyRunnable implements Runnable {
// @Override
// public void run() {
// System.out.println("Thread is running...");
// }
// }