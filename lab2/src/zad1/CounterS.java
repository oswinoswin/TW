package zad1;
public class CounterS {
    public int number = 0;
    public SemaforBin sem = new SemaforBin();

    public synchronized void increment() {

        number++;
        sem.podnies();
        // System.out.println("increment " + number);
    }

    public synchronized void decrement() {

        number--;
        sem.opusc();
        // System.out.println("decrement " + number);
    }

    public synchronized int value() {
        return number;
    }
}
