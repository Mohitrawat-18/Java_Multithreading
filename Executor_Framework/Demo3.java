package Executor_Framework;

import java.util.concurrent.*;

public class Demo3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // exception occured with try block also
        // executor.execute(() -> {
        //     int x = 10/0;
        // });

        // submit exception can be catched
        Future<Integer> f1 = executor.submit(() -> {
            return 10/0;
        });

        try{
            System.out.println(f1.get());
        }
        catch(Exception e){
            System.out.println("Catched submit exception");
        }

        executor.shutdown();
    }
}
