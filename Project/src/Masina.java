class Masina {
    String nume;
    private int nrLocuri = -1;

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }
    public void afisareMasina()
    {
        System.out.print(this.nume);
        System.out.print(" - ");
        System.out.println(this.nrLocuri);
    }
    public Masina(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }
}
