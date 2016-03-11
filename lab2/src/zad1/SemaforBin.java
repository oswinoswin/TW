package zad1;

/**
 * Created by oswin on 08.03.16.
 */
public class SemaforBin {
    boolean open = true;

    public synchronized void podnies() {

        open = true;
        notifyAll();
    }

    public synchronized void opusc() {

        while (!open) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        open = false;
    }

}
