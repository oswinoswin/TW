package zad2;
import java.util.Random;

public class Producer implements Runnable {
    private Buffer buffer;
    int M, id;

    public Producer(Buffer buffer,int id) {
        this.buffer = buffer;
        this.M = buffer.size();
        this.id = id;
    }

    public void run() {

        Random generator = new Random();
        int amount;
        for (int i = 0; i < 1; i++) {
            try {
                amount = generator.nextInt(M)+1;
                System.out.println("\tproducer nr " + id +" puts " + amount);
                buffer.put(amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}


