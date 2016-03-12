package zad3;


public class Main3 {
    public static void main(String[] args){
        Box box = new Box(5);

        synchronized (box){
            BoxRun b = new BoxRun(box);
            Thread t1 = new Thread(b);
            t1.start();
        }
    }


}
