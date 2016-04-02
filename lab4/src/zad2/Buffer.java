package zad2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    final Lock lock = new ReentrantLock();
    final Condition firstProd  = lock.newCondition();
    final Condition firstCons = lock.newCondition();
    final Condition restProd  = lock.newCondition();
    final Condition restCons = lock.newCondition();
    Boolean firstProdWaits, firstConsWaits;

    final Integer[] items;
    int M, inBuffer, start;

    Buffer(int M){
        this.M = M;
        inBuffer = 0;
        start = 0;
        firstProdWaits = false;
        firstConsWaits = false;
        items = new Integer[2*M];
    }
    public int size(){return this.M;}

    public void put(int amount) throws InterruptedException {
        lock.lock();
        try {
            //sprawdzic, czy ktos juz czeka
            if(firstProdWaits)
                restProd.await();

            while( 2*M - inBuffer < amount) {
                firstProd.await();
                firstProdWaits = true;
            }
            //if there is a place
            for(int i=0; i<amount; i++){
                System.out.println( "zapisywanie w " + (start + inBuffer)% (2*M));
                items[ (start + inBuffer)% (2*M)] = 1;
                inBuffer++;
            }

            restProd.signal();
            firstCons.signal();

        } finally {
            lock.unlock();
        }
    }

    public void take(int amount ) throws InterruptedException {
        lock.lock();
        try {
            //sprawdzic, czy jakis konsument czeka
            if(firstConsWaits)
                restCons.await();
            while(inBuffer < amount)
                firstCons.await();
            //mozna wziac

            for( int i=0; i< amount; i++){
                System.out.println("Zwalnianie w " + start%(2*M));
                items[start%(2*M)] = 0;
                inBuffer--;
                start++;
            }

            if(start >= 2*M )
                start = start%(2*M);

        } finally {
            lock.unlock();
        }
    }
}
