package zad2;

public class Sklep implements Runnable{
    Koszyk kosz;
    public Sklep(Koszyk kosz){
        this.kosz = kosz;
    }
    public void run() {
        kosz.oddaj();
        kosz.wez();
        kosz.wez();
        kosz.oddaj();
        kosz.wez();
        kosz.wez();
    }

}
