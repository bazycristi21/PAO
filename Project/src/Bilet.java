import java.util.ArrayList;

class Bilet {
    Oras plecare = new Oras("");
    Oras destinatie = new Oras("");
    int distanta = -1; // in km
    float pret = -1;  // in lei
    int timp = -1; // in minute
    float reducere = 0; // procent
    public Bilet(Oras plecare, Oras destinatie,int distanta, float reducere)
    {
        this.plecare = plecare;
        this.destinatie = destinatie;
        this.distanta = distanta;
        if( distanta == -1)
        {
            readCsv singleton = new readCsv();
            ArrayList<Bilet> bilete = singleton.readBilet();
            for(int i = 0; i < bilete.size(); i++)
            {
                if(bilete.get(i).plecare.nume.equals(this.plecare.nume) && bilete.get(i).destinatie.nume.equals( this.destinatie.nume))
                {

                    this.distanta = bilete.get(i).distanta;
                    break;
                }
            }
        }

        this.pret = Math.round(this.distanta / 3);
        this.pret = pret -  reducere / 100  * pret;
        this.timp = Math.round(60  * this.distanta / 80); // calculat pt viteza medie de 80km / h
        this.reducere = reducere;
    }
    public Bilet(Oras plecare, Oras destinatie,int distanta, float pret , int timp ,float reducere) {
        this.plecare = plecare;
        this.destinatie = destinatie;
        this.distanta = distanta;
        this.pret = pret -  reducere / 100  * pret;
        this.timp = timp;
        this.reducere = reducere;
    }
    public void afiseaza()
    {
        String deAfisat = this.plecare.nume + " -> " + this.destinatie.nume + " pret: " + this.pret;
        System.out.println(deAfisat);
    }
    public Oras getPlecare() {
        return plecare;
    }

    public void setPlecare(Oras plecare) {
        this.plecare = plecare;
    }

    public Oras getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(Oras destinatie) {
        this.destinatie = destinatie;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getTimp() {
        return timp;
    }

    public void setTimp(int timp) {
        this.timp = timp;
    }
    public static void main(String[] args)
    {
        Oras A = new Oras("Alexandria");
        Oras C = new Oras("Bucuresti");
        Bilet B = new Bilet(A,C,-1,0);

    }
}

