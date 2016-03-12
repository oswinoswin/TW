package zad3;

public class BoxRun implements Runnable {
    Box box;

    BoxRun(Box box){
        this.box = box;
    }

    public void run() {
        box.put();
        box.get();
        for(int i=0; i<6; i++){
            box.put();
        }
        for(int i=0; i<5; i++){
            box.get();
        }
        box.get();
    }
}
