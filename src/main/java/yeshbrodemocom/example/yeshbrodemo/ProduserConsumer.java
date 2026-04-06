package yeshbrodemocom.example.yeshbrodemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduserConsumer {
    static BlockingQueue<Integer> quae = new ArrayBlockingQueue<>(2);

    public static void main(String args[]){
        Thread produser = new Thread(()->{
            for (int i = 0;i<=10;i++){
                try {
                    quae.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("added"+i);
            }
        });

        Thread consumer  = new Thread(()->{
            for (int i = 0;i<=10;i++){
                String value  = null;
                try {
                    value = String.valueOf(quae.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("consume"+value);
            }
        });
        produser.start();
        consumer.start();

    }
}
