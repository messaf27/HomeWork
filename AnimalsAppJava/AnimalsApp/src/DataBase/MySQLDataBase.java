package DataBase;

import Animals.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLDataBase implements InterfaceDataBase{
    // JDBC URL, username and password of MySQL server
    private String url;
    private String user;
    private String password;

    // JDBC variables for opening and managing connection
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public MySQLDataBase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean open() {
        boolean result = false;
        try {
            // opening database connection to MySQL server
            this.con = DriverManager.getConnection(this.url, this.user, this.password);

            // getting Statement object to execute query
            this.stmt = con.createStatement();

            result = (!this.con.isClosed());

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
//            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    @Override
    public boolean close() {
        // TODO: Добавить механизм закрытия
        return true;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void addAnimal(Animal animal) {

    }

    @Override
    public String getAnimalFromId(int id) {
        return "";
    }

    @Override
    public boolean removeAnimal(Animal animal) {
        return false;
    }

    @Override
    public boolean removeAnimal(int id) {
        return false;
    }

    @Override
    public int getNumOfAnimals() {
        return 0;
    }

    public static class Commands {
        private final ArrayList<String> commands;

        public Commands() {
            commands = new ArrayList<>();
        }

        public ArrayList<String> addCommand(String command)
        {
            commands.add(command);
            return commands;
        }

        public String getCommands() {
            return commands.toString();
        }
    }
}
