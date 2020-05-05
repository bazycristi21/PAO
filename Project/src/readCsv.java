import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;


class readCsv{
    private static readCsv singletonReadBilet = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Date date = new Date();
    PrintWriter writer = null;
    public static readCsv getInstance()
    {
        if (singletonReadBilet == null)
            singletonReadBilet = new readCsv();

        return singletonReadBilet;
    }
    public void writeAudit(String text,Timestamp timestamp) throws IOException {
        try (FileWriter writer = new FileWriter("data/audit.csv",true)) {

            StringBuilder sb = new StringBuilder();

            sb.append(text);
            sb.append("  ,  ");
            sb.append(timestamp);
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Audit updated!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Bilet> readBilet()
    {
        String csvFile = "data/Bilet.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Bilet> bilete = new ArrayList<Bilet>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] detaliiBilet = line.split(cvsSplitBy);

                System.out.println("Plecare: " + detaliiBilet[0] + " , destinatie: " + detaliiBilet[1] );
                Bilet bilet = new Bilet(new Oras(detaliiBilet[0]), new Oras(detaliiBilet[1]),  Integer.parseInt(detaliiBilet[2]),0 );
                bilete.add(bilet);
            }

            writeAudit("Citire din Bilet.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bilete;
    }
    public void writeBilet(Bilet bilet) throws IOException {
        try (FileWriter writer = new FileWriter("data/Bilet.csv",true)) {

            StringBuilder sb = new StringBuilder();
            System.out.println(bilet.plecare.nume);
            sb.append(bilet.plecare.nume);
            sb.append(',');
            sb.append(bilet.destinatie.nume);
            sb.append(',');
            sb.append(bilet.distanta);
            sb.append('\n');

            writer.write(sb.toString());
            writeAudit("Scriere in Bilet.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    public ArrayList<Oras> readOras()
    {
        String csvFile = "data/Oras.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Oras> orase = new ArrayList<Oras>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] detaliiOras = line.split(cvsSplitBy);

                Oras oras = new Oras(detaliiOras[0]);
                orase.add(oras);
            }

            writeAudit("Citire din Oras.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return orase;
    }
    public void writeOras(Oras oras) throws IOException {
        try (FileWriter writer = new FileWriter("data/Oras.csv",true)) {

            StringBuilder sb = new StringBuilder();

            sb.append(oras.nume);
            sb.append('\n');

            writer.write(sb.toString());
            writeAudit("Scriere in Oras.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    public ArrayList<Ruta> readRuta()
    {
        String csvFile = "data/Ruta.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Ruta> rute = new ArrayList<Ruta>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] detaliiRuta = line.split(cvsSplitBy);
                ArrayList<Oras> orase = new ArrayList<Oras>();
                for(int i = 0; i < detaliiRuta.length; i++)
                    orase.add(new Oras(detaliiRuta[i]));
                Ruta Ruta = new Ruta(orase);

                System.out.println(Ruta.nume);

                rute.add(Ruta);
            }
            writeAudit("Citire din Ruta.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rute;
    }
    public void writeRuta(Ruta ruta) throws IOException {
        try (FileWriter writer = new FileWriter("data/Ruta.csv",true)) {

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ruta.getOrase().size(); i++)
            {
                sb.append(ruta.getOrase().get(i).nume);
                sb.append(',');
            }
            sb.append('\n');


            writer.write(sb.toString());
            writeAudit("Scriere in Ruta.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    public HashSet<Masina> readMasina()
    {
        String csvFile = "data/Masina.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashSet<Masina> masini = new HashSet<Masina>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] detaliiMasina = line.split(cvsSplitBy);

                System.out.println("Nume: " + detaliiMasina[0] );
                if(detaliiMasina[0].equals("Microbuz"))
                {
                    Microbuz masina = new Microbuz(detaliiMasina[0], Integer.parseInt(detaliiMasina[2]),10);
                    masini.add(masina);
                }
                else if (detaliiMasina[0].equals("Sprinter"))
                {
                    Sprinter masina = new Sprinter(detaliiMasina[0],Integer.parseInt(detaliiMasina[2]),Integer.parseInt(detaliiMasina[1]));
                    masini.add(masina);
                }
                else if (detaliiMasina[0].equals("Supraetajat"))
                {
                    Supraetajat masina = new Supraetajat(detaliiMasina[0],Integer.parseInt(detaliiMasina[2]),Integer.parseInt(detaliiMasina[1]),Integer.parseInt(detaliiMasina[3]));
                    masini.add(masina);
                }

            }
            writeAudit("Citire din Masina.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return masini;
    }
    public void writeMasina(Masina masina) throws IOException {
        try (FileWriter writer = new FileWriter("data/Masina.csv",true)) {

            StringBuilder sb = new StringBuilder();

            sb.append(masina.getNume());
            sb.append(',');
            if(masina.getNume() == "Microbuz")
                sb.append("0");
            else if (masina.getNume() == "Sprinter")
                sb.append(((Sprinter)masina).getLocBagaje());
            else
                sb.append(((Supraetajat)masina).getLocBagaje());
            sb.append(',');
            sb.append(masina.getNrLocuri());
            sb.append(',');
            if(masina.getNume().equals("Microbuz") || masina.getNume().equals("Sprinter"))
                sb.append("0");
            else
                sb.append(((Supraetajat)masina).getNrLocuriEtaj());
            sb.append('\n');
            writer.write(sb.toString());
            writeAudit("Scriere in Masina.csv",new Timestamp(date.getTime()));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void main(String[] args) throws IOException {
        readCsv singleton = new readCsv();
        ArrayList<Bilet> bilete = singleton.readBilet();
        for(int i = 0; i < bilete.size(); i++)
        {
            bilete.get(i).afiseaza();
        }
        ArrayList<Ruta> rute = singleton.readRuta();
        for(int i = 0; i < rute.size(); i++)
        {
            rute.get(i).afiseaza();
            System.out.println("");
        }
        HashSet<Masina> masini = singleton.readMasina();
        ArrayList<Oras> orase = singleton.readOras();
        for(int i = 0; i < orase.size(); i ++)
        {
            System.out.println(orase.get(i).nume);
        }
        Oras oras1 = new Oras("Baia mare");
        Oras oras2 = new Oras("Satu mare");

        Bilet bilet = new Bilet(oras1,oras2,120,0);
        singleton.writeBilet(bilet);

        Supraetajat sup = new Supraetajat("Supraetajat",10,5,10);
        singleton.writeMasina(sup);
    }
}

