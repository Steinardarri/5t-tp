/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throunhugbunadar.pkg5f.pkg2019;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author loftureinarsson
 */
public class Controller {
    
    private static String q1;
    private static String q2;
    private static int iter1;
    private static final int numberOfSeats = 4;
    private static int numberOfRows;
    
    /***
     * Establishes a connection with the database flights.db
     * 
     * @return Connection
     */
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
        }
        catch (Exception err) {
            System.err.println(err.getMessage());
        }
        return conn;
    }
    
    /***
     * Gets number of rows in an airplane 
     * 
     * @param conn
     * @param ps2
     * @return int
     */
    private static int getNumberOfRows(Connection conn, PreparedStatement ps2) {
        int numRows = 0;
        try {
            ResultSet rowCount = ps2.executeQuery();
            
            while (rowCount.next()) {
                numRows = rowCount.getInt("count(*)");
            }
            
        }
        catch (SQLException err) {
            System.err.println(err);
        }
        
        return numRows;
    }
    
    /***
     * Gets the number of flights return from the database query
     * 
     * @param conn
     * @param ps1
     * @return int
     */
    private static int getNumberOfFlights(Connection conn, PreparedStatement ps1) {
        int count = 0;
        try {
            ResultSet rs1rowcount = ps1.executeQuery();
            
            while (rs1rowcount.next()) {
                count = rs1rowcount.getInt("count(*)");
            }
            
        } 
        catch (SQLException err) {
            System.err.println(err);
        }
        
        return count;
    }
    
    /***
     * Converts month to number string
     * 
     * @param month
     * @return String
     */
    private static String getMonth(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
        }
        return "";
    }
    
    /***
     * Converts Calendar date with hour and minutes to String to be used for database queries
     * 
     * @param date
     * @return String
     */
    private static String getSqlTime(Calendar date) {
        String s = "";
        String dateString = String.valueOf(date.getTime());
        String hour = dateString.substring(11, 13);
        String minute = dateString.substring(14,16);
        String day = dateString.substring(8, 10);
        String month = getMonth(dateString.substring(4,7));
        String year = dateString.substring(24,28);
        
        s += (year + "-" + month + "-" + day + " " + hour + ":" + minute);
        
        return s;
    }
    
    /***
     * Converts Calendar date of month to String to be used 
     * in SQL query
     * 
     * @param date
     * @return String
     */
    private static String getSqlDate(Calendar date) {
        String s = "";
        String dateString = String.valueOf(date.getTime());
        System.out.println("dateString " + dateString);
        String day = dateString.substring(8, 10);
        String month = getMonth(dateString.substring(4,7));
        String year = dateString.substring(24);
        
        s += (year + "-" + month + "-" + day);
        System.out.println(s);
        return s;
    }  
    
    /***
     * Converts String date of month from SQL query to Calendar date
     * 
     * @param date
     * @return Calendar
     */
    private static Calendar convertToCalendar(String date) {
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));
        cal.set(year,month-1,day);
        // System.out.println(cal);
        return cal;
    }
        
    /***
     * Searches and returns flights that meet search criteria
     * 
     * @param from
     * @param to
     * @param startDate
     * @param endDate
     * @return Flight[]
     */
    public static ArrayList<Flight> searchFlight(String from, String to, Calendar startDate, Calendar endDate) {
        Connection conn = getConnection();
        
        ArrayList<Flight> flights = new ArrayList();
        
        q1 = (
            "SELECT rowid, * " +
            "FROM flights " +
            "WHERE out = ? " +
            "AND back = ? " +
            "AND date >= ? " + 
            "AND date <= ? "  
        );
        
        q2 = (
            "SELECT *, count(*) " +
            "FROM seats " +
            "WHERE id = ? "
        );
        
        String sqlStartDate = getSqlDate(startDate);
        String sqlEndDate = getSqlDate(endDate);
        System.out.println("hæ");
        System.out.println(sqlStartDate);
        System.out.println(sqlEndDate);
        try {
            // Select from flights
            PreparedStatement ps1 = conn.prepareStatement(q1);
            ps1.clearParameters();
            ps1.setString(1,from);
            ps1.setString(2,to);
            ps1.setString(3,sqlStartDate);
            ps1.setString(4,sqlEndDate);

            //int count = getNumberOfFlights(conn, ps1);
            // Kannski þarf ekki count ef það er hægt að nota append
            //flights = new Flight[count];
                  
            ResultSet rs1 = ps1.executeQuery();
            
            iter1 = 0;
            while (rs1.next()) {
                String fromWhere = rs1.getString("out");
                //System.out.println(fromWhere);
                String toWhere = rs1.getString("back");
                String dateResult = rs1.getString("date");
                //System.out.println("dateResult " + dateResult);
                int start = rs1.getInt("start");
                //System.out.println(start);
                //System.out.println(start);
                int end = rs1.getInt("end");
                int price = rs1.getInt("price");
                String flightCompany = rs1.getString("company");
                int id = rs1.getInt("id");
                //System.out.println(id);
                //RowId rowId = rs1.getRowId("rowid");
                //System.out.println("ég keyri");
                //System.out.println("what the hell");

                // Breyta dateResult í Calendar
                //System.out.println("dateResult " + dateResult);
                System.out.println("dateResult " +dateResult);
                System.out.println("dateResult " +fromWhere);
                Calendar calDate = convertToCalendar(dateResult);
                
                
                // Select from seats
                PreparedStatement ps2 = conn.prepareStatement(q2);
                ps2.clearParameters();
                ps2.setString(1, String.valueOf(id));              
                
                numberOfRows = getNumberOfRows(conn, ps2);                
                boolean[][] seats = new boolean[numberOfRows][numberOfSeats];
                
                ResultSet rs2 = ps2.executeQuery();
                
                int iter2 = 0;
                while (rs2.next()) {
                    //int row = rs2.getInt("row");
                    boolean a = rs2.getBoolean("a");
                    boolean b = rs2.getBoolean("b");
                    boolean c = rs2.getBoolean("c");
                    boolean d = rs2.getBoolean("d");
                    
                    seats[iter2][0] = a;
                    seats[iter2][1] = b;
                    seats[iter2][2] = c;
                    seats[iter2][3] = d;
                    
                    iter2++;
                } 
                
                Flight tempFlight = new Flight(price, fromWhere, toWhere, flightCompany, calDate, start, end, id, seats);
                
                flights.add(tempFlight);
                iter1++;
            }
        }
        catch (SQLException err) {
            System.err.println(err.getMessage());
        }
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }

        return flights;
        
    }
    
    /*
        Skoðar hvort tiltekið customerNumber er núþegar í gagnagrunninum
    */
    public static int isInDatabase(String customerEmail, String customerName){
        String querySearchCustomer = (
            "SELECT customer_email, customer_name "
            + "FROM customers "
            + "WHERE customer_email = ? "
        );
        
        Connection conn = getConnection();
        
        try {
            PreparedStatement psSearchCustomer = conn.prepareStatement(querySearchCustomer);
            
            psSearchCustomer.clearParameters();
            psSearchCustomer.setString(1, customerEmail);
            
            ResultSet rs = psSearchCustomer.executeQuery();
            
            if (rs.next()) {
                String custM = rs.getString("customer_email");
                String custN = rs.getString("customer_name");
                if (customerEmail.equals(custM)) {
                    if (!customerName.equals(custN)) {
                        //throw new RuntimeException("Customer email already taken");
                        //System.out.println("Customer email already taken");
                        return -1;
                    }
                    //return customerEmail.equals(custM);
                    return 0;
                }
                
            }
        }
            
        catch(SQLException e){
            System.err.println(e);
        }
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
        return 1;
    }
    
    /*
        Setur tiltekin customer inn í gagnagrunn ef hann er ekki til.
    */
    public static int addCustomer(String name, String email, int customerNumber) {
        
        int checkIfInDatabase = isInDatabase(email, name);
        
        if (checkIfInDatabase == -1) {
            return -1;
        }
        else if (checkIfInDatabase == 0) {
            return 0;
        }
        
        String query = (
                "INSERT INTO customers"
                + "(customer_number, customer_email, customer_name)"
                + "VALUES(?, ?, ?)"
                );
        
        Connection conn = getConnection();
        
        try{
            PreparedStatement psCust = conn.prepareStatement(query);
            
            psCust.clearParameters();
            psCust.setInt(1, customerNumber);
            psCust.setString(2, email);
            psCust.setString(3, name);
                        
            psCust.executeUpdate();
        }
        catch(SQLException e){
            System.err.println(e);
        }
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        return 1;
    }
    
    /***
     * Checks if a booking reference is already taken
     * Returns booking reference or -1 if booking reference does not exist
     * 
     * @param bookingReference
     * @return int
     */
    public static int searchBooking(int bookingReference) {
        String querySearchBooking = (
            "SELECT bookingreference "
            + "FROM bookings "
            + "WHERE bookingreference = ?"
        );
        
        Connection conn = getConnection();
        
        try {
            PreparedStatement psSearchBooking = conn.prepareStatement(querySearchBooking);
            
            psSearchBooking.clearParameters();
            psSearchBooking.setInt(1, bookingReference);
            
            ResultSet rs = psSearchBooking.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("bookingreference");
            }
        }
        catch (SQLException err) {
            
        }
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
        return -1;
    }
    
    /***
     * Checks if customer already exists
     * Returns customer number or -1 if customer does not exist in database
     * 
     * @param name
     * @param customerNumber
     * @return 
     */
    public static int searchCustomerNumber(String name, int customerNumber) {
        String querySearchCustomer = (
            "SELECT customer_number "
            + "FROM customers "
            + "WHERE customer_number = ? "
        );
        
        Connection conn = getConnection();
        
        int temp = -1;
        
        try {
            PreparedStatement psSearchCustomer = conn.prepareStatement(querySearchCustomer);
            
            psSearchCustomer.clearParameters();
            psSearchCustomer.setInt(1, customerNumber);
            
            ResultSet rs = psSearchCustomer.executeQuery();
            
            if (rs.next()) {
                temp = rs.getInt("customer_number");
                
            } 
        }
        catch (SQLException err) {
            System.err.println(err);
        }   
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
        
        return temp;
    }
    
    
    /***
     * Adds a passenger to the database with reference to booking
     * 
     * @param passengers 
     */
    public static void addPassengers(Passenger[] passengers) {
        String queryAddPassengers = (
            "INSERT INTO passengers "
            + "(passenger_number, passenger_name, bookingreference, outbound_row, outbound_seat, inbound_row, inbound_seat, food, ums, freecancellation) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"    
        );
        
        Connection conn = getConnection();
       
        try {
            for (int i = 0; i < passengers.length; i++) {
                PreparedStatement psAddPassenger = conn.prepareStatement(queryAddPassengers);

                psAddPassenger.clearParameters();
                psAddPassenger.setInt(1, passengers[i].getPassengerNumber());
                psAddPassenger.setString(2, passengers[i].getName());
                psAddPassenger.setInt(3, passengers[i].getBookingReference());
                psAddPassenger.setInt(4, passengers[i].getRow()[0]);
                psAddPassenger.setString(5, String.valueOf(passengers[i].getSeat()[0]));
                psAddPassenger.setInt(6, passengers[i].getRow()[1]);
                psAddPassenger.setString(7, String.valueOf(passengers[i].getSeat()[1]));
                psAddPassenger.setBoolean(8, passengers[i].isFood());
                psAddPassenger.setBoolean(9, passengers[i].isUms());
                psAddPassenger.setBoolean(10, passengers[i].isFreeCancellation());

                psAddPassenger.executeUpdate();
            }
        }
        catch (SQLException err) {
           System.err.println(err.getMessage());
        }
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
           
    }
    
    
    /***
     * Reserves seat of flights
     * 
     * @param passengers
     * @param flights 
     */
    private static void reserveSeat(Passenger[] passengers, ArrayList<Flight> flights) {
        Connection conn = getConnection();
        System.out.println("flights.length " + flights.size());
        try {
            for (int j = 0; j < flights.size(); j++) {
                //System.out.println(flights[j].getId());
                if (flights.get(j) != null) {
                    for (int i = 0; i < passengers.length; i++) {
                        
                        char[] seats = passengers[i].getSeat();
                        int[] rows = passengers[i].getRow();
                        
                        for (int k = 0; k < seats.length; k++) {
                            if (rows[j] != -1) {
                                String queryReserveSeat = (
                                "UPDATE seats SET " + String.valueOf(seats[j]) + " = 1 WHERE row = ? AND id = ? "
                                );
                                System.out.println(queryReserveSeat);
                                PreparedStatement psReserveSeat = conn.prepareStatement(queryReserveSeat);



                                psReserveSeat.clearParameters();
                                psReserveSeat.setInt(1, rows[j]);
                                psReserveSeat.setInt(2, flights.get(j).getId());

                                psReserveSeat.executeUpdate();
                            }
                            
                        }
                         
                    }
                }
                
            }            
        }
        catch (SQLException err) {
            System.err.println(err);
        }       
    }
    
    
    /***
     * Books one or two flights (outbound, inbound) with an array of passengers 
     * and adds to database
     * 
     * @param bookingReference
     * @param customerNumber
     * @param flight
     * @param passengers 
     */
    public static void bookFlight(int bookingReference, int customerNumber, ArrayList<Flight> flight, Passenger[] passengers) {
        String queryBookFlight = (
            "INSERT INTO bookings (bookingreference, customer_number, out, back) "
            + "VALUES (?, ?, ?, ?)"    
        );
        
        Connection conn = getConnection();
        
        try {
            PreparedStatement psBookFlight = conn.prepareStatement(queryBookFlight);
            
            int outbound = -1;
            
            if (!flight.isEmpty()) {
                outbound = flight.get(0).getId();
            }
            
            int inbound = -1;
            if (flight.size() >= 2) {
                inbound = flight.get(1).getId();
            }  
            
            psBookFlight.clearParameters();
            psBookFlight.setInt(1, bookingReference);           
            psBookFlight.setInt(2, customerNumber);
            psBookFlight.setInt(3, outbound);
            psBookFlight.setInt(4, inbound);
            
            psBookFlight.executeUpdate();
            
            addPassengers(passengers);
            
            // Reserves seat for each flight
            reserveSeat(passengers, flight);
            
        }
        catch (SQLException err) {
            //System.err.println("error " + err.getErrorCode());
            if (err.getErrorCode() == 19) {
                int newBookingReference = Search.makeBookingReference();
                
                // Þurfum líka að breyta bookingReference hjá öllum farþegum í leiðinni
                for (int i = 0; i < passengers.length; i++) {
                    passengers[i].setBookingReference(newBookingReference);
                }
                bookFlight(newBookingReference, customerNumber, flight, passengers);
            }
            
            
        }
        finally
        {
          try
          {
            if(conn != null)
              conn.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
       
    }
    
    public static void main(String[] args) { 
        /*
        // Testa search()
        //int drasl = 19032019;
        //Date testDate = new Date(2019 - 1900, 3, 13, 15, 0);
        //System.out.println(testDate.getMinutes());
        //GregorianCalendar testCalendar = new GregorianCalendar(2019 - 1900, 2, 13, 3, 0);
        //System.out.println("Hour " + testCalendar.HOUR);
        Calendar cal = Calendar.getInstance();
        cal.set(2019, 2, 19);
        //System.out.println("tími " + cal.toString());
        String datetest = String.valueOf(cal.getTime());
        //System.out.println(datetest);
        //System.out.println(datetest.substring(11, 13));
        Flight[] test = searchFlight("Reykjavik","Akureyri",cal, cal); 
        //System.out.println(test.length);
        //System.out.println(test[0].getBrottfor());
        //System.out.println(test[0].getKoma());
        for (int i = 0; i < test.length-1; i++) {
            System.out.println("flug id " + test[i].getId());
        }
        // Testa bookFlight
        //int bookingReference, String name, int row, String seat, boolean food, boolean ums, boolean freeCancellation
        Passenger testPassenger = new Passenger(123, "Loftur", 10, 'a', false, false, true);
        Passenger[] testPassengerArray = {testPassenger};
        bookFlight(123, 12345, test, testPassengerArray);
        
        Passenger testPassenger2 = new Passenger(1234, "Ekki Loftur", 11, 'b', false, false, true);
        Passenger[] testPassengerArray2 = {testPassenger2};
        bookFlight(123, 123456, test, testPassengerArray2);
       */
    }
    
}
