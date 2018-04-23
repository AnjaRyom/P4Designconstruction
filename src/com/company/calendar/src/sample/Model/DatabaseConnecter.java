package sample.Model;

import java.sql.*;

/**
 * <h1> DatabaseConnecter<h1/>
 * This class describes the connection to the database
 * by having an connection method and a SQL-statement method
 */

public class DatabaseConnecter {

    static Connection connection;

    /**
     * This method creates the connection to the database
     */
    public static void ConnectToDatabase(){
        String connectionString = "jdbc:sqlite:Hairdresser.db";

        try{
          connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * This method sends a SQL statement to the database
     * @param sqlStatement String - the string representation of the SQL statement that is send to the database
     * @return ResultSet - set of results from the database
     * @throws SQLException throws an exception
     */
    public static ResultSet SendSQLStatement(String sqlStatement) throws SQLException {
        if (connection == null){
            System.out.println("Der er ikke forbindelse til databasen");
            throw new SQLException();
        } else {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sqlStatement);
        }
    }

}


