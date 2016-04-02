package zad2;

public class Main2 {

    public static void main(String args[]){
        Buffer buffer = new Buffer(4);
        Producer bob = new Producer(buffer, 1);
        Thread ted = new Thread(bob);
        ted.start();

        for(int i=0; i< 3; i++){
            (new Thread(new Producer(buffer,i))).start();
            (new Thread(new Consumer(buffer,1))).start();
        }
    }
}
