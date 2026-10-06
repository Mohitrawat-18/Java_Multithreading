package Executor_Framework;

import java.util.concurrent.CompletableFuture;

public class Demo5 {
    public static void main(String[] args) {
        // Completable future
        // CompletableFuture<Integer> f1 = 
        //     CompletableFuture.supplyAsync(() -> 10)
        //     .thenApply(result -> result * 2)
        //     .thenApply(result -> result * 3);

        //  CompletableFuture<Void> f1 = 
        //     CompletableFuture.supplyAsync(() -> 10)
        //     .thenAccept(result -> System.out.println(result));

        // CompletableFuture<Void> f1 = 
        //     CompletableFuture.supplyAsync(() -> 10)
        //     .thenRun(() -> System.out.println("Done"));

        // try{
        // System.out.println(f1.get());
        // }
        // catch(Exception e){}

        // thenCombined()
        CompletableFuture<Integer> f1 = 
            CompletableFuture.supplyAsync(() -> 10);
            
        CompletableFuture<Integer> f2 = 
            CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Void> result = 
            f1.thenCombine(f2, (a,b) -> a+b)
                .thenAccept(result2 -> System.out.println(result2));
    }
}
