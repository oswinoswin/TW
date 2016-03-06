
package com.company;

public class Main {

    public static void main(String[] args) {

        Counter licznik = new Counter();

        Incr i = new Incr(licznik);
        Dec d = new Dec(licznik);

        Thread t1 = new Thread(i);
        Thread t2 = new Thread(d);

        t1.start();
        t2.start();

        System.out.println( "main " + licznik.value() );
    }
}


