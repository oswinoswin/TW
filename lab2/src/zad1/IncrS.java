package zad1;


public class IncrS implements Runnable {
    public CounterS licz;

    public IncrS(CounterS licznik){
        this.licz = licznik;
    }
    public void run() {
        for(int i=0; i<10000; i++){
            System.out.println("increment");
            licz.increment();
        }
        System.out.println(licz.number);
    }
}
