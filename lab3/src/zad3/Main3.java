package zad3;

public class Main3 {

    public static void main(String args[]){

        int N = 4;//liczba par
        Kelner kelner = new Kelner(N);

        for(int i =0; i < N; i++){
            (new Thread(new Osoba(i,kelner))).start();
            (new Thread(new Osoba(i,kelner))).start();
        }

    }

}
