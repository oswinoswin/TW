package zad3;

public class Osoba implements Runnable{
    int j;
    Kelner kelner;

    Osoba(int j, Kelner kelner){
        this.j = j;
        this.kelner = kelner;
    }

    void wlasne_sprawy(){
        System.out.println("Osoba z pary nr: "+ j + " coś robi.");
    }

    void jedzenie(){
        System.out.println("Osoba z pary nr: "+ j + " teraz je.");
    }

    public void run(){
        wlasne_sprawy();
        try {
            kelner.chce_stolik(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jedzenie();
        System.out.println("Osoba z pary nr: "+ j + " zwalnia stolik.");
        kelner.zwalniam();
       /* try {
            System.out.println("Osoba z pary nr: "+ j + " zwalnia stolik.");
            kelner.zwalniam();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
