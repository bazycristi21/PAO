class Client {
    String nume = "";
    int varsta;
    boolean handicap = false;

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

    public Client(String nume, int varsta, boolean handicap) {
        this.nume = nume;
        this.varsta = varsta;
        this.handicap = handicap;
    }
}
