package zad3;

public class zad3 {
    public static void main(String args[]){
        Buffer buff = new Buffer();
        (new Thread(new Producer(buff))).start();
        (new Thread(new Producer(buff))).start();

        (new Thread(new Consumer(buff))).start();
        (new Thread(new Consumer(buff))).start();

        (new Thread(new Producer(buff))).start();
        (new Thread(new Consumer(buff))).start();

    }

    static void showThreadStatus(Thread thrd) {
        System.out.println(thrd.getName()+ "Alive:="+  thrd.isAlive()+ "State:=" + thrd.getState() );
    }
}
