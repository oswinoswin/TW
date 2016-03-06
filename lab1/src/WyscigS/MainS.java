package WyscigS;

/**
 * Created by oswin on 02.03.16.
 */

public class MainS {

    public static void main(String[] args) {

        CounterS licznik = new CounterS();

       synchronized (licznik){
           IncrS i = new IncrS(licznik);
           DecS d = new DecS(licznik);

           Thread t1 = new Thread(i);
           Thread t2 = new Thread(d);

           t1.start();
           t2.start();
       }

        System.out.println( "main " + licznik.value() );
    }
}


