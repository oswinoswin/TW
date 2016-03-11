package zad2;


public class Main2 {

    public static void main(String[] args) {

        Koszyk kosz = new Koszyk(5);

        synchronized (kosz){
            Sklep sklep = new Sklep(kosz);
            Thread t1 = new Thread(sklep);
            t1.start();
        }


    }
}