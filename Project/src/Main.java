import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args)
    {
        Oras Bucuresti = new Oras("Bucuresti");
        Oras Alexandria = new Oras("Alexandria");
        Oras Timisoara = new Oras("Timisoara");
        Oras Cluj = new Oras("Cluj");
        Oras Iasi = new Oras("Iasi");
        Oras Craiova = new Oras("Craiova");
        Oras Ploiesti = new Oras("Ploiesti");
        Oras Brasov = new Oras("Brasov");
        Oras Sibiu = new Oras("Sibiu");
        Oras PiatraNeamt = new Oras("Piatra Neamt");
        Oras Constanta = new Oras("Constanta");

        ArrayList<Oras> Orase = new ArrayList<Oras>();

        Orase.add(Bucuresti);
        Orase.add(Alexandria);
        Orase.add(Timisoara);
        Orase.add(Cluj);
        Orase.add(Iasi);
        Orase.add(Craiova);
        Orase.add(Ploiesti);
        Orase.add(Brasov);
        Orase.add(Sibiu);
        Orase.add(PiatraNeamt);
        Orase.add(Constanta);

        ArrayList<Oras> o1 = new ArrayList<Oras>();
        o1.add(Bucuresti);
        o1.add(Alexandria);
        o1.add(Craiova);
        o1.add(Timisoara);
        Ruta R1 = new Ruta(o1);
        ArrayList<Oras> o2 = new ArrayList<Oras>();
        o2.add(Bucuresti);
        o2.add(Ploiesti);
        o2.add(Brasov);
        o2.add(Sibiu);
        o2.add(Cluj);
        Ruta R2 = new Ruta(o2);
        ArrayList<Oras> o3 = new ArrayList<Oras>();
        o3.add(Bucuresti);
        o3.add(Constanta);
        Ruta R3 = new Ruta(o3);
        ArrayList<Oras> o4 = new ArrayList<Oras>();
        o4.add(Bucuresti);
        o4.add(PiatraNeamt);
        o4.add(Iasi);
        Ruta R4 = new Ruta(o4);
        ArrayList<Ruta> Rute = new ArrayList<Ruta>();
        Rute.add(R1);
        Rute.add(R2);
        Rute.add(R3);
        Rute.add(R4);

        Sprinter M1 = new Sprinter(8,10);
        Sprinter M2 = new Sprinter(8,10);
        Sprinter M3 = new Sprinter(9,8);
        Sprinter M4 = new Sprinter(9,8);
        Microbuz M5 = new Microbuz(12,15);
        Microbuz M6 = new Microbuz(14,15);
        Supraetajat M7 = new Supraetajat(30,15,12);
        Supraetajat M8 = new Supraetajat(34,12,14);
        HashSet<Masina> Flota = new HashSet<Masina>();
        Flota.add(M1);
        Flota.add(M2);
        Flota.add(M3);
        Flota.add(M4);
        Flota.add(M5);
        Flota.add(M6);
        Flota.add(M7);
        Flota.add(M8);


        Servicii S = new Servicii(Rute,Orase,Flota);
        // Interogari
        System.out.println(S.esteRuta("Alexandria","Timisoara"));
        S.afisareFlota();
        S.afisareRute();
        S.adaugareRuta(o4);
        S.afisareRute();

    }
}
