package yeshbrodemocom.example.yeshbrodemo;

public class EvenOddByUsingWait {
    int num = 1;
    final int value = 10;

    public synchronized void evenNumber() throws InterruptedException {
        while (num <= value) {
            if (num % 2 != 0) {
                wait();
            }
            System.out.println("even" + num);
            if(num==10)
                break;
            num++;
            notify();
        }
    }

    public synchronized void oddNumber() throws InterruptedException {
        while (num <= value) {
            if (num % 2 == 0) {
                wait();
            }
            System.out.println("odd" + num);
            num++;
            notify();
        }
    }

    public static void main(String[] args) {
        EvenOddByUsingWait yesh = new EvenOddByUsingWait();
        Thread even = new Thread(() -> {
            try {
                yesh.evenNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread odd = new Thread(() -> {
            try {
                yesh.oddNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        even.start();
        odd.start();
    }
}
