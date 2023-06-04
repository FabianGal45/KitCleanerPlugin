package eu.ovmc.kitcleanerplugin;

import java.sql.*;

public class SQLiteJDBC {
    public Connection connectToCMIDB(){
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:plugins/CMI/cmi.sqlite.db");
            System.out.println("Connected to the CMI database.");

        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e +" Database Connection FAILED!");
        }

        return con;
    }

    public ResultSet getRS(Connection con){
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery( "SELECT users.Balance, users.username, users.player_uuid FROM users;" );

        } catch (SQLException e) {
            System.out.println(e +" Database Connection FAILED!");
        }

        return rs;

    }

    public void removeKits(Connection con){
        String query = "UPDATE users SET Kits = NULL;";

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            con.close();
            System.out.println("Removed all kits from all players");

        } catch (SQLException e) {
            System.out.println("Something went wrong removing the kits.");
            e.printStackTrace();
        }
    }




}
