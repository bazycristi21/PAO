class Masina {
    String nume;
    private int nrLocuri = -1;

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public String getNume() {
        return nume;
    }

    public void afiseaza()
    {
        System.out.print(this.nume);
        System.out.print(" - ");
        System.out.println(this.nrLocuri);
    }
    public Masina(String nume,int nrLocuri) {
        this.nume = nume;
        this.nrLocuri = nrLocuri;
    }
}
