package zad3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;

public class Kelner {
    int N;
    final Lock lock = new ReentrantLock();
    final Condition naStolik  = lock.newCondition();
    final Condition[] naPare = new Condition[100];
    Integer[] czeka_na_pare = new Integer[100];
    int przy_stoliku;


    Kelner(int N){
        this.N = N;
        for ( int i =0; i<N; i++ ){
            czeka_na_pare[i] = 0;
            naPare[i] = lock.newCondition();
        }
        przy_stoliku = 0;
    }

    public void chce_stolik(int j) throws InterruptedException { //j - numer pary
        lock.lock();
        try{
            System.out.println("Osoba z pary nr: "+j+" probuje rezerwowac stolik.");
            czeka_na_pare[j]++;
            if( czeka_na_pare[j] < 2) {
                naPare[j].await();
            }
            else{
                while( przy_stoliku > 0 )
                    naStolik.await();

                przy_stoliku = 2;
                System.out.println("Para nr: "+j+" dostala stolik.");
                naPare[j].signal();
            }

        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void zwalniam() {
        lock.lock();
        try {
            przy_stoliku--;
            if(przy_stoliku == 0) {
                naStolik.signal();
                System.out.println("\tTable has been released.");
            }
        } finally {
            lock.unlock();
        }
    }
}