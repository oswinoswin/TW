package zad2;


public class Koszyk {
    public int number;
    public Semafor sem;
    Koszyk(int ile){
        System.out.println("Teraz koszykow: " + ile);
        this.number = ile;
        sem = new Semafor(ile);
    }


    public void oddaj() {

        System.out.println("Oddaj koszyk nr" + number);
        number++;
        sem.podnies();
        System.out.println("pozostalo " + number);
    }

    public void wez() {
        System.out.println("Wez koszyk nr" + number);
        number--;
        sem.opusc();
        System.out.println("pozostalo " + number);
    }

    public synchronized int value() {
        return number;
    }
}
