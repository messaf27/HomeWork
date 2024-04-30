package DataBase;

import Classes.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public boolean connect() {
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
    public boolean create(String dbTableName) {

        String query = "CREATE TABLE IF NOT EXISTS "+ dbTableName + "("+
                            "id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                            "type VARCHAR(45) NOT NULL," +
                            "type_name VARCHAR(45)," +
                            "year_movie YEAR," +
                            "count_min INT UNSIGNED,"+
                            "storyline TEXT," +
                            "animal_id INT UNSIGNED NOT NULL " +
                        ");";


        return false;
    }

    @Override
    public void addAnimal(Animal animal) {

    }

}
