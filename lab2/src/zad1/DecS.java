package zad1;

/**
 * Created by oswin on 02.03.16.
 */
public class DecS implements Runnable{
    public CounterS licz;
    public DecS(CounterS licznik){
        this.licz = licznik;
    }
    public void run() {

        for(int i=0; i<10000; i++){
            System.out.println("decrement");
            licz.decrement();
        }

        System.out.println(licz.number);
    }
}
