package zad1;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {


        for (int i = 0; i < 11; i++) {
            try {
                buffer.put("message "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}


