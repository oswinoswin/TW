package WyscigS;

/**
 * Created by oswin on 02.03.16.
 */
public class IncrS implements Runnable {
    public CounterS licz;
    public IncrS(CounterS licznik){
        this.licz = licznik;
    }
    public void run() {
        for(int i=0; i<100000000; i++){
            licz.increment();
        }
    }
}
