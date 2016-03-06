package zad3;


public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer drop) {
        this.buffer = drop;
    }

    public void run() {


        for (int i = 0; i < 10; i++) {
            buffer.put("message "+i);
            System.out.println("put");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
