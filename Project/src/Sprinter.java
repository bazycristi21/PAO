class Sprinter extends Masina{
    int locBagaje = 0; // in m^3

    public int getLocBagaje() {
        return locBagaje;
    }

    public void setLocBagaje(int locBagaje) {
        this.locBagaje = locBagaje;
    }

    public Sprinter(String nume, int nrLocuri, int locBagaje) {
        super(nume,nrLocuri);
        this.locBagaje = locBagaje;
        this.nume = "Sprinter";
    }
}
