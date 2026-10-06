package Lock_Free_Concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class Demo3 {
    public static void main(String[] args) {
        LikeCounter likeCounter = new LikeCounter();

        Thread t1 = new Thread(() -> likeCounter.like());
        Thread t2 = new Thread(() -> likeCounter.like());
        Thread t3 = new Thread(() -> likeCounter.like());
        Thread t4 = new Thread(() -> likeCounter.like());
        Thread t5 = new Thread(() -> likeCounter.like());
        Thread t6 = new Thread(() -> likeCounter.like());
        Thread t7 = new Thread(() -> likeCounter.like());
        Thread t8 = new Thread(() -> likeCounter.like());
        Thread t9 = new Thread(() -> likeCounter.like());
        Thread t10 = new Thread(() -> likeCounter.like());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
            Thread.sleep(3000);
        }
        catch(Exception e){}

        System.out.println("Total Likes : "+likeCounter.getTotalLikes());
    }
}

class LikeCounter{
    AtomicReference<Integer> totalCount = new AtomicReference<>(0);
    
    public void like(){

        Integer currentCount;
        Integer finalCount;

        while (true) {
            //1. we will capture the latest value of total count
            currentCount = totalCount.get();

            //2. increment like counter by 1
            finalCount = currentCount + 1;

            //3. check again, if the count is still what i saw.
            if(totalCount.compareAndSet(currentCount, finalCount)){
                return;
            }

            //4. if a thread reaches here, someone else have updated the count value
            // re-try
            System.out.println("Conflict detected. Re-trying..");
        }
    }

    public int getTotalLikes(){
        return totalCount.get();
    }
}
