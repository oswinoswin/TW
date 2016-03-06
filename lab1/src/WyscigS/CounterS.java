package WyscigS;

public class CounterS {
    public int number = 0;

    public synchronized void increment() {
        number++;
        // System.out.println("increment " + number);
    }

    public synchronized void decrement() {
        number--;
        // System.out.println("decrement " + number);
    }

    public synchronized int value() {
        return number;
    }
}
