package daytour;

import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Search {

	/**
	 * Search for tours from database with matching name, price and date
	 * 
	 * @param searchInput
	 * @param pricebar    (price range from pricebar[0] to pricebar[1])
	 * @param datebar     (date range from datebar[0] to datebar[1])
	 * @return resulting tours as ArrayList of objects
	 */
	public ArrayList<Tour> getTours(String searchInput, String location, int[] pricebar, Calendar[] datebar) {
		if (pricebar.length == 0) {
			pricebar = new int[2];
			pricebar[0] = 0;
			pricebar[1] = Integer.MAX_VALUE;
		}
		
		if (datebar.length == 0) {
			datebar = new Calendar[2];
			datebar[0] = new GregorianCalendar(1900,0,1); // 1900.01.01
			datebar[1] = new GregorianCalendar(2100,0,1); // 2100.01.01
		}
		
		String url = "jdbc:sqlite:src/Data/daytour.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String sql = "SELECT * FROM Tour WHERE name LIKE \'%" + searchInput + "%\' AND price >= " + pricebar[0]
				+ " AND price <= " + pricebar[1] + " AND date >= date(\'" + sdf.format(datebar[0].getTime()) + "\') AND date <= date(\'"
				+ sdf.format(datebar[1].getTime()) + "\') AND area LIKE \'" + location + "\'";
		System.out.println("Searching for: " + sql);

		ArrayList<Tour> tour = new ArrayList<Tour>();
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date"));
				String desc = rs.getString("desc");
				int length = rs.getInt("length");
				String language = rs.getString("language");
				int price = rs.getInt("price");
				int difficultyLevel = rs.getInt("difficultyLevel");
				int ageLimit = rs.getInt("ageLimit");
				String area = rs.getString("area");
				String conditions = rs.getString("conditions");

				Tour tour1 = new Tour(id, name, date, desc, length, language, price, difficultyLevel, ageLimit, area,
						conditions);
				tour.add(tour1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tour;
	}
	
	
	public static void addTour(Tour tour, String name, String address) {
		String url = "jdbc:sqlite:src/Data/daytour.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try (Statement stmt = conn.createStatement()) {
				String query = "INSERT INTO BOOKING (tourID, name, address) VALUES (\'" + tour.id + "\', \'" + name + "\', \'" + address + "\')";
				System.out.println("Sent SQL query: " + query);
				stmt.executeUpdate(query);
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Tests the above code
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Search search = new Search();
		int[] pricebar = new int[0];

		Calendar[] datebar = new Calendar[0];
		//datebar[0] = new java.sql.Date(119, 00, 01);
		//datebar[1] = new java.sql.Date(119, 02, 01);

		ArrayList<Tour> matchingTours = search.getTours("Golden", "Reykjavik", pricebar, datebar);
		
		System.out.println("Search results: \n");
		for (int i = 0; i < matchingTours.size(); i++) {
			System.out.println(matchingTours.get(i));
		}
		
		addTour(matchingTours.get(0), "svn5", "Kópavogur");
	}

}
