public class Incr implements Runnable {
    public Counter licz;
    public Incr(Counter licznik){
        this.licz = licznik;
    }
    public void run() {
        for(int i=0; i<100000000; i++){
            licz.increment();
        }
        System.out.println(licz.number);
    }
}
