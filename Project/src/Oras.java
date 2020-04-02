public class Oras {
    String nume = "";

    public Oras(String nume) {
        this.nume = nume;
    }
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public static void main(String[] args)
    {
        Oras A = new Oras("Alexandria");
        System.out.println(A.nume);
    }


}
