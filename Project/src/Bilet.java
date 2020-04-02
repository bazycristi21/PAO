class Bilet {
    Oras plecare = new Oras("");
    Oras destinatie = new Oras("");
    float pret = -1;  // in lei
    int timp = -1; // in minute
    float reducere = 0; // procent

    public Bilet(Oras plecare, Oras destinatie, float pret, int timp,float reducere) {
        this.plecare = plecare;
        this.destinatie = destinatie;
        this.pret = pret -  reducere / 100  * pret;
        this.timp = timp;
        this.reducere = reducere;
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
        Bilet B = new Bilet(A,C,25,75,10);
        System.out.print(B.pret);
    }
}
