/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throunhugbunadar.pkg5f.pkg2019;

/**
 *
 * @author loftureinarsson
 */
import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Kannski ekki public
public class Setup {
  public static void main(String[] args) throws Exception {
    
    Connection conn = null;
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:flights.db");
    }
    catch (Exception err) {
      
    }
    try {
      Statement statement = conn.createStatement();

      statement.executeUpdate("drop table if exists airplanes");
      statement.executeUpdate("drop table if exists seats");
      statement.executeUpdate("drop table if exists bookings");
      statement.executeUpdate("drop table if exists customers");
      statement.executeUpdate("drop table if exists passengers");
      statement.executeUpdate("drop table if exists flights");
      

      String airplanes = (
        "CREATE TABLE airplanes (\n"
        + "flightnumber varchar(60) \n"
        + ")"
      );
      statement.executeUpdate(airplanes);
      String seats = (
        "CREATE TABLE seats (\n"
        + "id int REFERENCES flights(id),"
        + "row int, \n"
        + "a boolean default 0, \n"
        + "b boolean default 0, \n"
        + "c boolean default 0, \n"
        + "d boolean default 0 \n"
        + ")"
      );
      statement.executeUpdate(seats);
      String bookings = (
        "CREATE TABLE bookings ( \n"
        + "bookingreference int unique, \n"
        + "customer_number int REFERENCES customers(customer_number), \n"
        + "out varchar(260), \n"
        + "back varchar(260) \n"
        + ")"
      );
      statement.executeUpdate(bookings);
      String customers = (
        "CREATE TABLE customers ( \n"
        + "customer_number int unique, \n"
        + "customer_email varchar(260), \n"
        + "customer_name varchar(260), \n"
        + "PRIMARY KEY (customer_number, customer_name, customer_email) \n"
        + ")"
      );
      statement.executeUpdate(customers);
      String passengers = (
        "CREATE TABLE passengers ( \n"
        + "passenger_number int, \n"
        + "passenger_name varchar(260), \n"
        + "bookingreference int, \n"
        + "outbound_row int, \n"
        + "outbound_seat varchar(2), \n"
        + "inbound_row int, \n"
        + "inbound_seat varchar(2), \n"
        + "food boolean, \n"
        + "ums boolean, \n"
        + "freecancellation boolean \n"
        + ")"
      );
      statement.executeUpdate(passengers);
      String flights = (
        "CREATE TABLE flights ( \n"
        + "id INTEGER PRIMARY KEY AUTOINCREMENT, \n"      
        + "out varchar(260), \n"
        + "back varchar(260), \n"
        + "start date, \n"
        + "end date, \n"
        + "date date, \n"
        + "company varchar(260), \n"
        + "flightnumber varchar(60) REFERENCES airplanes(flightnumber), \n"
        + "price int \n"
        + ")"
      );
      statement.executeUpdate(flights);


    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    finally {
      System.out.println("Töflur búnar til");
      conn.close();
    }
   
    
    

  }
}