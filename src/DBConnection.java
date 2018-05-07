
/**
 *
 * @author cody
 */


import java.sql.*;
import java.sql.SQLException;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class DBConnection {
    static boolean connected = false;
    public static Connection conn = null;
    public static Statement statement = null;
    public static CallableStatement cStatement;
    public static String hostName = "Postgres";
    public static String dbInstanceName = "plumbingdb"; 
    public static String dbUser = "plumbingdb", password = "tokyo18",
            url = "jdbc:postgresql://localhost:5432/plumbingdb";
    
    public static Connection connect() {
        try {
            conn = DriverManager.getConnection(url, dbUser, password);
            System.out.println("Connected to PostgreSQL server successfully.");
            connected = true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            connected = false;
        }
        return conn;
    }
    
    public static ResultSet getResultSet(String sql) {
        try {
        statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
        ResultSet result = statement.executeQuery(sql);
        return result;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /*
    public static int getProblemid() {
        try {
            cStatement = conn.prepareCall("{? = call getProblemID (?)}");
            cStatement.registerOutParameter(1, Types.INTEGER);
            cStatement.setInt(2, Globals.ticketid);
            cStatement.execute();
            
        }
        catch {
        }
        return -1;
    }*/
}
