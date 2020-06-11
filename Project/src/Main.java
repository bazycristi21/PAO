import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args)
    {
        readCsv singletonCitire = new readCsv();
        ArrayList<Oras> Orase = singletonCitire.readOras();

        ArrayList<Ruta> Rute = singletonCitire.readRuta();

        HashSet<Masina> Flota = singletonCitire.readMasina();

        Servicii S = new Servicii(Rute,Orase,Flota);
        // Interogari
        System.out.println(S.esteRuta("Alexandria","Timisoara"));
        S.afisareFlota();
        S.afisareRute();
        Masina m = new Masina("Microbuz",0);
        S.afisare(m);

        jdbc jdbc = new jdbc();
        jdbc.setRuta();
        Oras o1 = new Oras("Alexandria");
        Oras o2 = new Oras("Bucuresti");
        ArrayList<Oras> orase1 = new ArrayList<>();
        orase1.add(o1);
        orase1.add(o2);
        Ruta r1 = new Ruta(orase1);
        jdbc.deleteRuta(r1);
    }
}
