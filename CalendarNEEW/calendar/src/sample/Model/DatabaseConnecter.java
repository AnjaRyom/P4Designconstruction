package sample.Model;

import java.sql.*;

public class DatabaseConnecter {

    static Connection connection;

    public static void ConnectToDatabase(){
        String connectionString = "jdbc:sqlite:Hairdresser.db";

        try{
          connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

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


