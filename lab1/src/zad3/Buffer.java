package zad3;
import java.util.*;
public class Buffer {

    LinkedList<String> storage = new LinkedList<String>();
    int available = -1;

    public synchronized String take() {

        while (available < 0) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        available --;
        notifyAll();
        return storage.pollLast();
    }

    public synchronized void put(String message) {

        while (available > 10) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        available ++;
        storage.add(message);
        notifyAll();
    }
}


