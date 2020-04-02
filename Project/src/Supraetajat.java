class Supraetajat extends Sprinter {
    int nrLocuriEtaj = 0;

    public int getNrLocuriEtaj() {
        return nrLocuriEtaj;
    }

    public void setNrLocuriEtaj(int nrLocuriEtaj) {
        this.nrLocuriEtaj = nrLocuriEtaj;
    }

    public Supraetajat(int nrLocuri, int locBagaje,int nrLocuriEtaj) {
        super(nrLocuri,locBagaje);
        this.nrLocuriEtaj = nrLocuriEtaj;
        this.nume = "Supraetajat";
    }
}
