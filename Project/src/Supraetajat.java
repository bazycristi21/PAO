class Supraetajat extends Sprinter {
    int nrLocuriEtaj = 0;

    public int getNrLocuriEtaj() {
        return nrLocuriEtaj;
    }

    public void setNrLocuriEtaj(int nrLocuriEtaj) {
        this.nrLocuriEtaj = nrLocuriEtaj;
    }

    public Supraetajat(String nume, int nrLocuri, int locBagaje,int nrLocuriEtaj) {
        super(nume,nrLocuri,locBagaje);
        this.nrLocuriEtaj = nrLocuriEtaj;
        this.nume = "Supraetajat";
    }
}
