/**
 * Created by oswin on 02.03.16.
 */
public class Dec implements Runnable {
    public Counter licz;
    public Dec(Counter licznik){
        this.licz = licznik;
    }
    public void run() {
        for(int i=0; i<100000000; i++){
            licz.decrement();
        }
        System.out.println(licz.number);
    }
}
