import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
class Servicii {
    private ArrayList<Ruta> Rute = new ArrayList<Ruta>();
    private ArrayList<Oras> Orase = new ArrayList<Oras>();
    private HashSet<Masina> Flota = new HashSet<Masina>();
    public Servicii(ArrayList<Ruta> rute, ArrayList<Oras> orase,HashSet<Masina> flota) {
        Rute = rute;
        Orase = orase;
        Flota = flota;
    }

    public HashSet<Masina> getFlota() {
        return Flota;
    }

    public void setFlota(HashSet<Masina> flota) {
        Flota = flota;
    }
    public void adaugareFlota(Masina A)
    {
        Flota.add(A);
        System.out.println("Noua masina a fost adaugata in flota");
    }
    public ArrayList<Ruta> getRute() {
        return Rute;
    }
    public void setRute(ArrayList<Ruta> rute) {
        Rute = rute;
    }
    public ArrayList<Oras> getOrase() {
        return Orase;}
    public void setOrase(ArrayList<Oras> orase)
    {
        Orase = orase;
    }
    public void afisareFlota() {
        System.out.print("In present se afla ");
        System.out.print(this.Flota.size());
        System.out.println(" masini in flota.");
        for(Masina m:Flota)
        {
            m.afiseaza();
        }
    }
    public void afisareRute()
    {
        for(int i = 0; i < this.Rute.size(); i++)
        {
            System.out.print(this.Rute.get(i).nume);
            System.out.print(" : ");
            for(int j = 0; j < this.Rute.get(i).getOrase().size(); j++)
            {
                System.out.print(this.Rute.get(i).getOrase().get(j).nume);
                if(j < this.Rute.get(i).getOrase().size() - 1)
                {
                    System.out.print(" - ");
                }
            }
            System.out.println(".");
        }
    }
    public void adaugareRuta(ArrayList<Oras> orase)
    {
        Rute.add(new Ruta(orase));
        System.out.println("Noua ruta a fost adaugata");
    }
    public <T> void afisare(T a)
    {
        //
    }
    public String esteRuta(String Oras1, String Oras2)
    {
        boolean gasit1 = false;
        boolean gasit2 = false;
        for(int i = 0; i < Rute.size();i++)
        {
            gasit1 = false;
            gasit2 = false;
            for(int j = 0; j < Rute.get(i).getOrase().size();j++)
            {
                if(Rute.get(i).getOrase().get(j).nume == Oras1)
                    gasit1 = true;
                if(Rute.get(i).getOrase().get(j).nume == Oras2)
                    gasit2 = true;
            }
            if( gasit1 == true && gasit2 == true )
            {
                return "Exista ruta intre cele 2 orase";
            }
        }
        return "Nu exista ruta";

    }
}
