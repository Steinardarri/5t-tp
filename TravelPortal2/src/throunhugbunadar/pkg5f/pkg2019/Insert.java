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
public class Insert {
  public static void main(String[] args) throws Exception {
    Connection conn;

    Class.forName("org.sqlite.JDBC");
    conn = DriverManager.getConnection("jdbc:sqlite:flights.db");

    String[] queryArr = new String[85];
    queryArr[0] = "INSERT INTO airplanes (flightnumber) VALUES ('FI101')";
    queryArr[1] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '09:00', '10:00', '2019-03-19', 'Flugleiðir', 'FI101', 15000)";
    queryArr[2] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '16:00', '17:00', '2019-03-19', 'Flugleiðir', 'FI102', 15000)";
    queryArr[3] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-19', 'Flugleiðir', 'FI101', 15000)";
    queryArr[4] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-19', 'Flugleiðir', 'FI102', 15000)";
    queryArr[5] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-19', 'Flugleiðir', 'FI103', 18000)";
    queryArr[6] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-19', 'Flugleiðir', 'FI101', 16000)";
    queryArr[7] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-19', 'Flugleiðir', 'FI103', 18000)";
    queryArr[8] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-19', 'Flugleiðir', 'FI101', 18000)";
    queryArr[9] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-19', 'Flugleiðir', 'FI102', 16000)";
    queryArr[10] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-19', 'Flugleiðir', 'FI103', 16000)";
    queryArr[11] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-19', 'Flugleiðir', 'FI102', 16000)";
    queryArr[12] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-19', 'Flugleiðir', 'FI103', 16000)";
    queryArr[13] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '09:00', '10:00', '2019-03-20', 'Flugleiðir', 'FI101', 15000)";
    queryArr[14] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '16:00', '17:00', '2019-03-20', 'Flugleiðir', 'FI102', 15000)";
    queryArr[15] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-20', 'Flugleiðir', 'FI101', 15000)";
    queryArr[16] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-20', 'Flugleiðir', 'FI102', 15000)";
    queryArr[17] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-20', 'Flugleiðir', 'FI103', 18000)";
    queryArr[18] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-20', 'Flugleiðir', 'FI101', 16000)";
    queryArr[19] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-20', 'Flugleiðir', 'FI103', 18000)";
    queryArr[20] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-20', 'Flugleiðir', 'FI101', 18000)";
    queryArr[21] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-20', 'Flugleiðir', 'FI102', 16000)";
    queryArr[22] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-20', 'Flugleiðir', 'FI103', 16000)";
    queryArr[23] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-20', 'Flugleiðir', 'FI102', 16000)";
    queryArr[24] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-20', 'Flugleiðir', 'FI103', 16000)";
    queryArr[25] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '09:00', '10:00', '2019-03-21', 'Flugleiðir', 'FI101', 15000)";
    queryArr[26] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '16:00', '17:00', '2019-03-21', 'Flugleiðir', 'FI102', 15000)";
    queryArr[27] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-21', 'Flugleiðir', 'FI101', 15000)";
    queryArr[28] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-21', 'Flugleiðir', 'FI102', 15000)";
    queryArr[29] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-21', 'Flugleiðir', 'FI103', 18000)";
    queryArr[30] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-21', 'Flugleiðir', 'FI101', 16000)";
    queryArr[31] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-21', 'Flugleiðir', 'FI103', 18000)";
    queryArr[32] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-21', 'Flugleiðir', 'FI101', 18000)";
    queryArr[33] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-21', 'Flugleiðir', 'FI102', 16000)";
    queryArr[34] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-21', 'Flugleiðir', 'FI103', 16000)";
    queryArr[35] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-21', 'Flugleiðir', 'FI102', 16000)";
    queryArr[36] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-21', 'Flugleiðir', 'FI103', 16000)";
    queryArr[37] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '09:00', '10:00', '2019-03-22', 'Flugleiðir', 'FI101', 15000)";
    queryArr[38] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '16:00', '17:00', '2019-03-22', 'Flugleiðir', 'FI102', 15000)";
    queryArr[39] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-22', 'Flugleiðir', 'FI101', 15000)";
    queryArr[40] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-22', 'Flugleiðir', 'FI102', 15000)";
    queryArr[41] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-22', 'Flugleiðir', 'FI103', 18000)";
    queryArr[42] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-22', 'Flugleiðir', 'FI101', 16000)";
    queryArr[43] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-22', 'Flugleiðir', 'FI103', 18000)";
    queryArr[44] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-22', 'Flugleiðir', 'FI101', 18000)";
    queryArr[45] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-22', 'Flugleiðir', 'FI102', 16000)";
    queryArr[46] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-22', 'Flugleiðir', 'FI103', 16000)";
    queryArr[47] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-22', 'Flugleiðir', 'FI102', 16000)";
    queryArr[48] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-22', 'Flugleiðir', 'FI103', 16000)";
    queryArr[49] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '09:00', '10:00', '2019-03-23', 'Flugleiðir', 'FI101', 15000)";
    queryArr[50] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '16:00', '17:00', '2019-03-23', 'Flugleiðir', 'FI102', 15000)";
    queryArr[51] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-23', 'Flugleiðir', 'FI101', 15000)";
    queryArr[52] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-23', 'Flugleiðir', 'FI102', 15000)";
    queryArr[53] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-23', 'Flugleiðir', 'FI103', 18000)";
    queryArr[54] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-23', 'Flugleiðir', 'FI101', 16000)";
    queryArr[55] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-23', 'Flugleiðir', 'FI103', 18000)";
    queryArr[56] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-23', 'Flugleiðir', 'FI101', 18000)";
    queryArr[57] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-23', 'Flugleiðir', 'FI102', 16000)";
    queryArr[58] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-23', 'Flugleiðir', 'FI103', 16000)";
    queryArr[59] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-23', 'Flugleiðir', 'FI102', 16000)";
    queryArr[60] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-23', 'Flugleiðir', 'FI103', 16000)";
    queryArr[61] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '09:00', '10:00', '2019-03-24', 'Flugleiðir', 'FI101', 15000)";
    queryArr[62] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik', 'Akureyri', '16:00', '17:00', '2019-03-24', 'Flugleiðir', 'FI102', 15000)";
    queryArr[63] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-24', 'Flugleiðir', 'FI101', 15000)";
    queryArr[64] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-24', 'Flugleiðir', 'FI102', 15000)";
    queryArr[65] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-24', 'Flugleiðir', 'FI103', 18000)";
    queryArr[66] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-24', 'Flugleiðir', 'FI101', 16000)";
    queryArr[67] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-24', 'Flugleiðir', 'FI103', 18000)";
    queryArr[68] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-24', 'Flugleiðir', 'FI101', 18000)";
    queryArr[69] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-24', 'Flugleiðir', 'FI102', 16000)";
    queryArr[70] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-24', 'Flugleiðir', 'FI103', 16000)";
    queryArr[71] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-24', 'Flugleiðir', 'FI102', 16000)";
    queryArr[72] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-24', 'Flugleiðir', 'FI103', 16000)";
    queryArr[73] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '12:00', '13:00', '2019-03-25', 'Flugleiðir', 'FI101', 15000)";
    queryArr[74] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Akureyri', 'Reykjavik', '18:00', '19:00', '2019-03-25', 'Flugleiðir', 'FI102', 15000)";
    queryArr[75] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '08:00', '09:00', '2019-03-25', 'Flugleiðir', 'FI103', 18000)";
    queryArr[76] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavík', 'Ísafjörður', '17:00', '18:00', '2019-03-25', 'Flugleiðir', 'FI101', 16000)";
    queryArr[77] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavík', '10:00', '11:00', '2019-03-25', 'Flugleiðir', 'FI103', 18000)";
    queryArr[78] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Ísafjörður', 'Reykjavik', '19:00', '20:00', '2019-03-25', 'Flugleiðir', 'FI101', 18000)";
    queryArr[79] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '10:30', '11:30', '2019-03-25', 'Flugleiðir', 'FI102', 16000)";
    queryArr[80] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-25', 'Flugleiðir', 'FI103', 16000)";
    queryArr[81] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-25', 'Flugleiðir', 'FI102', 16000)";
    queryArr[82] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '19:30', '20:30', '2019-03-25', 'Flugleiðir', 'FI103', 16000)";
    queryArr[83] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Eigilsstaðir', 'Reykjavik', '21:30', '22:30', '2019-03-25', 'Flugleiðir', 'FI103', 16000)";
    queryArr[84] = "INSERT INTO flights (out, back, start, end, date, company, flightnumber, price) VALUES ('Reykjavik','Eigilsstaðir', '08:30', '09:30', '2019-03-25', 'Flugleiðir', 'FI102', 16000)";
    
    try {
      Statement statement = conn.createStatement();
      for (String q : queryArr) { 
        statement.executeUpdate(q);
      }
      
      ResultSet rowids = statement.executeQuery("SELECT id FROM flights");
      
      String insert = "INSERT INTO seats (id, row) VALUES (?, ?)";
      PreparedStatement ps = conn.prepareStatement(insert);
      while (rowids.next()) {
        ps.setInt(1,rowids.getInt("id"));
        for (int i = 1; i <= 20; i++) {
            ps.setInt(2,i);
            ps.executeUpdate();
        }
      }
      
      System.out.println("Gögnum bætt við");

    }
    catch (SQLException e) {
      System.err.println(e.getMessage());
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
}