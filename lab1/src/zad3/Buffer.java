package zad3;
import java.util.*;
public class Buffer {

    LinkedList<String> storage = new LinkedList<String>();
    boolean pusty = true;

    public synchronized String take() {

        while (pusty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        pusty = true;
        notifyAll();
        return storage.pollLast();
    }

    public synchronized void put(String message) {

        while (!pusty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        pusty = false;
        storage.add(message);
        notifyAll();
    }
}


