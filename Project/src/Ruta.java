import java.util.ArrayList;

public class Ruta {
    private ArrayList<Oras> orase = new ArrayList<Oras>();
    String nume = "";

    public Ruta(ArrayList<Oras> orase) {
        this.orase = orase;
        this.nume = orase.get(0).nume + " -> " + orase.get(orase.size() - 1).nume;
    }

    public ArrayList<Oras>  getOrase() {
        return orase;
    }

    public void setOrase(ArrayList<Oras> orase) {
        this.orase = orase;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public void prelungesteRuta(Oras A)
    {
        // adauga un oras la finalul rutei
        orase.add(A);
        this.nume = this.orase.get(0).nume + " -> " + A.nume;
    }
    public void adaugaOras(Oras o1, Oras o2)
    {
        // adauga orasul o1 dupa orasul o2 in ruta actuala
        for(int i = 0; i < this.orase.size(); i++)
        {
            if(this.orase.get(i) == o2)
            {
                this.orase.add(i+1,o1);
                break;
            }
        }
    }
    public void eliminaOras(Oras B)
    {
        // elimina orasul B din ruta
        if(this.orase.get(0) == B)
        {
            System.out.println("Nu puteti elimina orasul de plecare");
            return;
        }

        if(this.orase.get(orase.size()-1) == B)
        {
            System.out.println("Nu puteti elimina orasul de sosire");
            return;
        }
        System.out.print("Ati eliminat orasul ");
        System.out.print(B.nume);
        System.out.print(" din ruta ");
        System.out.println(this.nume);
        this.orase.remove(B);
    }
    public static void main(String[] args)
    {
        Oras O1 = new Oras("Alexandria");
        Oras O2 = new Oras("Bucuresti");
        Oras O3 = new Oras("Ploiesti");
        ArrayList<Oras> orase = new ArrayList<Oras>();
        orase.add(O1);
        orase.add(O2);
        orase.add(O3);
        Ruta R = new Ruta(orase);
        //R.eliminaOras(O2);
        R.adaugaOras(O3,O1);
        for(int i = 0; i < R.orase.size();i ++)
        {
            System.out.println(R.orase.get(i));
        }
    }
}
