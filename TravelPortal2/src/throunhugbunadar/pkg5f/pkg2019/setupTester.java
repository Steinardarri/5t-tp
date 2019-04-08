/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matthías Dan Flemmingsson
 */
package throunhugbunadar.pkg5f.pkg2019;

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 *
 * @author Matthías Dan
 */
public class setupTester {
    
    public static boolean tester(String statements) throws SQLException{
        Connection conn = null;
        try {
          Class.forName("org.sqlite.JDBC");
          conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
        }
        catch (Exception err) {

        }
        try {
          Statement statement = conn.createStatement();
          statement.execute(statements);
        }
        catch (SQLException e) {
          System.out.println(e.getMessage());
          return false;
        }
        finally {
          conn.close();
          return true;
        }
    }
    
    @Test
    public static void main(String args[]) throws SQLException{
       assertEquals(tester("SELECT name FROM sqlite_master WHERE type='table' AND name='airplanes'"), true);
       assertEquals(tester("SELECT name FROM sqlite_master WHERE type='table' AND name='seats'"), true);
       assertEquals(tester("SELECT name FROM sqlite_master WHERE type='table' AND name='bookings'"), true);
       assertEquals(tester("SELECT name FROM sqlite_master WHERE type='table' AND name='customers'"), true);
       assertEquals(tester("SELECT name FROM sqlite_master WHERE type='table' AND name='passengers'"), true);
       assertEquals(tester("SELECT name FROM sqlite_master WHERE type='table' AND name='flights'"), true);
    } 
   
    
}
