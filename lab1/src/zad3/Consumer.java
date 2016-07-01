package zad3;

public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i=0; i<11; i++) {
            System.out.format("MESSAGE RECEIVED: %s%n", buffer.take());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
