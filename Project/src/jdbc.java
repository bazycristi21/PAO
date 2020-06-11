import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc{
    public void setBilet()
    {

        String createTableSql = "CREATE TABLE IF NOT EXISTS bilete" +
                "(id int PRIMARY KEY AUTO_INCREMENT, plecare varchar(30), destinatie varchar(30),pret double)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper repositoryHelper = Helper.getHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addBilet(Bilet bilet) {
        String insertBilet = "INSERT INTO bilete(plecare,destinatie,pret) VALUES('" + bilet.plecare.nume + "','" + bilet.destinatie.nume + "'," + bilet.pret + ")";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertBilet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ArrayList<Bilet> readBilet() {
        String selectBilet = "SELECT * FROM bilete";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();
        ArrayList<Bilet> bilete = new ArrayList<Bilet>();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectBilet);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Bilet bilet = new Bilet(resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                bilete.add(bilet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bilete;
    }
    public void deleteBilet(Bilet bilet)
    {
        String deleteBilet = "DELETE FROM bilete WHERE plecare = '" + bilet.getPlecare().nume  + "' and destinatie = '" + bilet.getDestinatie().nume + "'";
        System.out.print(deleteBilet);
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deleteBilet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setMasina()
    {

        String createTableSql = "CREATE TABLE IF NOT EXISTS masini" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30),loc_bagaje int,locuri int, locuri_etaj int)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper repositoryHelper = Helper.getHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addMasina(Masina masina)
    {
        int loc_bagaje = 0;
        int loc_etaj = 0;
        if(masina.nume == "Sprinter" )
        {
            loc_bagaje = ((Sprinter)masina).getLocBagaje();
        }
        else if(masina.nume == "Supraetajat")
        {
            loc_bagaje = ((Supraetajat)masina).getLocBagaje();
            loc_etaj = ((Supraetajat)masina).getNrLocuriEtaj();
        }
        String insertMasina = "INSERT INTO masini(nume,loc_bagaje,locuri,locuri_etaj) VALUES('" + masina.nume + "'," + loc_bagaje + "," + masina.getNrLocuri() + "," +  loc_etaj + ")";
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertMasina);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ArrayList<Masina> readMasina() {
        String selectMasina = "SELECT * FROM masini";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();
        ArrayList<Masina> masini = new ArrayList<Masina>();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectMasina);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                if(resultSet.getString(5) == "Masina" )
                {
                    Masina masina = new Masina(resultSet.getString(5), resultSet.getInt(3));
                    masini.add(masina);
                }
                else if(resultSet.getString(5) == "Microbuz")
                {
                    Microbuz microbuz = new Microbuz(resultSet.getString(5), resultSet.getInt(3),10);
                    masini.add(microbuz);
                }
                else if(resultSet.getString(5) == "Sprinter")
                {
                    Sprinter sprinter = new Sprinter(resultSet.getString(5), resultSet.getInt(3),resultSet.getInt(2));
                    masini.add(sprinter);
                }
                else if(resultSet.getString(5) == "Supraetajat")
                {
                    Supraetajat supraetajat = new Supraetajat(resultSet.getString(5), resultSet.getInt(3),resultSet.getInt(2),resultSet.getInt(4));
                    masini.add(supraetajat);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return masini;
    }
    public void deleteMasina(Masina masina)
    {
        String deletesql = "DELETE FROM masini WHERE nume =" + masina.nume  + "and  locuri = " + masina.getNrLocuri();
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deletesql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setRuta()
    {

        String createTableSql = "CREATE TABLE IF NOT EXISTS rute" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(300))";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper repositoryHelper = Helper.getHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addRuta(Ruta ruta)
    {
        String nume = "";
        int i = 0;
        for(i = 0; i < ruta.getOrase().size() - 1; i++)
        {
            nume += ruta.getOrase().get(i).nume + ",";
        }
        nume += ruta.getOrase().get(i).nume;
        String insertMasina = "INSERT INTO rute(nume) VALUES('" + nume  + "')";
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertMasina);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ArrayList<Ruta> readRuta() {
        String selectOras = "SELECT * FROM rute";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();
        ArrayList<Ruta> rute = new ArrayList<Ruta>();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectOras);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String[] rutaStr = resultSet.getString(2).split(",");
                ArrayList<Oras> ruta = new ArrayList<Oras>();
                for(int i = 0; i < rutaStr.length; i++)
                {
                    Oras oras = new Oras(rutaStr[i]);
                    ruta.add(oras);
                }
                Ruta ruta1 = new Ruta(ruta);
                rute.add(ruta1);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rute;
    }
    public void deleteRuta(Ruta ruta)
    {
        String nume = "";
        int i = 0;
        for(i = 0; i < ruta.getOrase().size() - 1; i++)
        {
            nume += ruta.getOrase().get(i).nume + ",";
        }
        nume += ruta.getOrase().get(i).nume;
        String deletesql = "DELETE FROM orase WHERE nume = '" + nume  + "'";
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deletesql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setOras()
    {

        String createTableSql = "CREATE TABLE IF NOT EXISTS orase" +
                "(id int PRIMARY KEY AUTO_INCREMENT, nume varchar(30))";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper repositoryHelper = Helper.getHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addOras(Oras oras)
    {

        String insertOras = "INSERT INTO orase(nume) VALUES('" + oras.nume  + "')";
        System.out.print(insertOras);
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, insertOras);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public ArrayList<Oras> readOras() {
        String selectOras = "SELECT * FROM orase";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();
        ArrayList<Oras> orase = new ArrayList<Oras>();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectOras);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                Oras oras = new Oras(resultSet.getString(2));
                orase.add(oras);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orase;
    }
    public void deleteOras(Oras oras)
    {
        String deletesql = "DELETE FROM orase WHERE nume = " + oras.nume  ;
        Connection databaseConnection =  DatabaseConfiguration.getDatabaseConnection();
        Helper databaseHelper = Helper.getHelper();

        try {
            databaseHelper.executeSql(databaseConnection, deletesql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        jdbc jdbc =  new jdbc();




    }
}