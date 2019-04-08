/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*Packages*/
package throunhugbunadar.pkg5f.pkg2019;

/*Imports*/
import java.io.*;
import java.sql.*;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Matthías Dan
 */
public class InsertTester {
      
    @Before
    private static void setUp() throws ClassNotFoundException, SQLException{
        Connection conn = null;  
        try {
          Class.forName("org.sqlite.JDBC");
          conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
        }
        catch (SQLException err) {
            System.out.print(err);
        }
        String queryFlights = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '07:00', '08:00', '2019-03-30', 'TestFlight', 'TF100', 100)";   
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(queryFlights);
            
            System.out.println("Test data added");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        finally {
            try {
              if(conn != null) {
                conn.close();
              }       
            }
            catch(SQLException e) {
              System.err.println(e);
            }
        }
    }
               
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    private static void test() throws SQLException, ClassNotFoundException {
        Connection conn = null; 
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
            String[] valueTestArr = {"Reykjavik", "Eigilsstaðir", "07:00", "08:00", "2019-03-30", "TestFlight", "TF100", "100"};
            String[] sqlTestArr = {"out", "back", "start", "end", "date", "company", "flightnumber", "price"};
            Statement statement = conn.createStatement();
            if(valueTestArr.length == sqlTestArr.length){
                ResultSet result = statement.executeQuery("SELECT * FROM flights WHERE company = 'TestFlight'");
                for(int i = 0; i < valueTestArr.length; i++){
                    String value = result.getString(sqlTestArr[i]);
                    assertEquals(valueTestArr[i], value);
                    System.out.println("Table row: "+sqlTestArr[i]+"\n Test data: "+valueTestArr[i]+"\n SQLData: "+value);
                }   
                System.out.println("SQL database inteqrity good");
            }
       }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        finally {
         try {
           if(conn != null) {
             conn.close();
           }       
         }
         catch(SQLException e) {
           System.err.println(e);
         }
       }
    }
    
    @After
    private static void cleanUp() throws SQLException, ClassNotFoundException{
        Connection conn = null; 
        try{        
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
            Statement statement = conn.createStatement();
            statement.executeUpdate("DELETE FROM flights WHERE company = 'TestFlight'");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        finally {
          try {
            if(conn != null) {
              conn.close();
              System.out.println("Test data deleted");
            }       
          }
          catch(SQLException e) {
            System.err.println(e);
          }
        }
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        setUp();
        test();
        cleanUp();
    }
}
