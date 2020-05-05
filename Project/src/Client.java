class Client {
    String nume = "";
    int varsta;
    boolean handicap = false;
    Oras plecare = null;
    Oras destinatie = null;
    Bilet bilet = null;
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public boolean getHandicap() {
        return handicap;
    }

    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    public Client(String nume, int varsta, boolean handicap,Oras plecare, Oras destinatie) {
        this.nume = nume;
        this.varsta = varsta;
        this.handicap = handicap;
        int reducere = 0;
        this.plecare = plecare;
        this.destinatie = destinatie;
        if(this.handicap)
        {
            reducere += 15;
        }
        if(this.varsta >= 60 || this.varsta <= 14)
        {
            reducere += 20;
        }
        this.bilet = new Bilet(plecare,destinatie,-1,reducere);

    }
}
