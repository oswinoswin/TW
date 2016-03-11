package zad2;

/**
 * Created by nazwa on 2016-03-08.
 */
public class Semafor {

    int ile;

    Semafor(int number){
        this.ile = number;
    }

    public synchronized void podnies() {

        ile++;
        notifyAll();
    }

    public synchronized void opusc() {
        while (ile < 1) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        ile--;
        notifyAll();
    }

}
