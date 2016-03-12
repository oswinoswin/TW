package zad3;

/**
 * Created by oswin on 12.03.16.
 */
public class Semafor2 {
    Semafor top;
    Semafor down;
    Semafor2(int max){
        this.top = new Semafor(max);
        this.down = new Semafor(max);
    }

    public synchronized void podnies() {

        top.podnies();
        down.opusc();
    }

    public synchronized void opusc() {

        top.opusc();
        down.podnies();
    }


}
