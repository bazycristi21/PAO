class Microbuz extends Masina {
    int reducere = 0;
    // se aplica reducere deoarece nu exista loc de bagaje
    public int getReducere() {
        return reducere;
    }

    public void modifReducere(int reducere) {
        this.reducere = reducere;
    }

    public Microbuz(int nrLocuri, int reducere) {
        super(nrLocuri);
        this.reducere = reducere;
        this.nume = "Microbuz";
    }
}
