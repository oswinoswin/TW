package zad3;


public class Box {
    int curr=0;
    int max; //pojemnosc puedlka
    Semafor2 sem;
    Box(int max){
        this.max = max;
        this.sem = new Semafor2(max);
    }

    public void put() {

        //System.out.println("Wkladam przedmioe nr" + curr);
        curr++;
        sem.podnies();
        System.out.println("Po dodaniu " + curr);
    }

    public void get() {
        //System.out.println("Wez koszyk nr" + number);
        curr--;
        sem.opusc();
        System.out.println("Po zabraniu " + curr);
    }


}
