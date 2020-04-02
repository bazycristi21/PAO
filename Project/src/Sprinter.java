class Sprinter extends Masina{
    int locBagaje = 0; // in m^3

    public int getLocBagaje() {
        return locBagaje;
    }

    public void setLocBagaje(int locBagaje) {
        this.locBagaje = locBagaje;
    }

    public Sprinter(int nrLocuri, int locBagaje) {
        super(nrLocuri);
        this.locBagaje = locBagaje;
        this.nume = "Sprinter";
    }
}
