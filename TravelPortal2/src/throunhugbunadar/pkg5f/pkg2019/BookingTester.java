/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package throunhugbunadar.pkg5f.pkg2019;

import java.sql.*;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import throunhugbunadar.pkg5f.pkg2019.Flight;
import throunhugbunadar.pkg5f.pkg2019.Passenger;
import static throunhugbunadar.pkg5f.pkg2019.Search.bookFlight;
import static throunhugbunadar.pkg5f.pkg2019.Search.makeBookingReference;
import static throunhugbunadar.pkg5f.pkg2019.Search.searchFlight;
import java.util.ArrayList;

/**
 *
 * @author Matthías Dan
 */
public class BookingTester {
    static Calendar cal;
    static private int bookingNum;
    static Passenger tempPassenger;
    static ArrayList<Flight> flightResult;
    static Passenger[] bookedPassangers;
    static int bookingResult;
    
    public BookingTester() {
    }
    
    private static Passenger[] makePassArr(Passenger pass){
        Passenger[] arr = {pass};
        return arr;
    }
    
    private static void deleteFromDatabase(String query, int num) throws ClassNotFoundException {
        /*
        Tengist gagnagrunninum og eyðir út test data og loka síðan connection
        */
        Connection conn = null; 
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
           }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        try{
            PreparedStatement statement = conn.prepareStatement(query);
            statement.clearParameters();
            statement.setInt(1, num);
            statement.executeQuery();
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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public static void setUp() {
        /*Býr til ný test gögn og notar núverandi föll í leitarvélinni til þess
        að setja gögninn á sinn stað 
        */
        cal = Calendar.getInstance();
        cal.set(2019,2,19);
        flightResult = searchFlight("Reykjavik", "Akureyri", cal, cal);
        
        bookingNum = makeBookingReference();
        tempPassenger = new Passenger(bookingNum, "Tester Testsen", 1, 'a', 1, 'a', false, false, true);
        bookedPassangers = makePassArr(tempPassenger);
        
        bookingResult = bookFlight(bookingNum, "Tester Testsen", "tester@test.com", true, "Credit", flightResult, bookedPassangers);
        System.out.println("Testdata created");
    }
     
    @After
    public static void tearDown() throws ClassNotFoundException {
        String query = "DELETE FROM bookings WHERE bookingreference = ?";
        
        deleteFromDatabase(query, bookingNum);
    }

   @Test
    public static void test() throws ClassNotFoundException, SQLException{
        /*Kallar á setup(Nánari lýsing á setup í fallinu sjálfu
         Leitar af test gögnum í gagnagrunninum til að sjá hvort þau eru
        til staðar og eyðir þeim síðan úr gagnagrunninum með tearDown fallinu.
        */
        setUp();
        Connection conn = null; 
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
           }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        try{
            String query = "SELECT * FROM bookings WHERE bookingreference = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            
            statement.setInt(1, bookingNum);
            
            ResultSet res = statement.executeQuery();
            int sqlBookingRef = res.getInt("bookingreference");

            assertEquals(bookingNum, res.getInt("bookingreference"));

            query = "SELECT * FROM passengers WHERE bookingreference = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, res.getInt("bookingreference"));

            res = statement.executeQuery();

            assertEquals(res.getString("passenger_name"), "Tester Testsen");

            System.out.println("Nafn farþega Tester Testsen, Nafn sem skráð var í gagnagrunninum er: "+res.getString("passenger_name"));
            System.out.println("Bókunarnr sem var búið til fyrir innsetningu í gagnagrunn er: "+bookingNum+" og það bókunarnr sem var sótt í gagnagrunn er: "+sqlBookingRef);
            System.out.println("Test sucsessful");
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
        tearDown();
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        setUp();
        test();
        tearDown();
    }
}
