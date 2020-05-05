class Microbuz extends Masina {
    int reducere = 10;
    // se aplica reducere deoarece nu exista loc de bagaje
    public int getReducere() {
        return reducere;
    }

    public void modifReducere(int reducere) {
        this.reducere = reducere;
    }

    public Microbuz(String nume,int nrLocuri, int reducere) {
        super(nume,nrLocuri);
        this.reducere = reducere;
        this.nume = "Microbuz";
    }
}
