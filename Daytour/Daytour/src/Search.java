package Data;

import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Search {

	/**
	 * Search for tours from database with matching name, price and date
	 * 
	 * @param searchInput
	 * @param pricebar    (price range from pricebar[0] to pricebar[1])
	 * @param datebar     (date range from datebar[0] to datebar[1])
	 * @return resulting tours as objects
	 */
	public Tour[] getTours(String searchInput, int[] pricebar, java.sql.Date[] datebar) {
		String url = "jdbc:sqlite:src/Data/daytour.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		String sql = "SELECT * FROM Tour WHERE name LIKE \'%" + searchInput + "%\' AND price >= " + pricebar[0]
				+ " AND price <= " + pricebar[1] + " AND date >= date(\'" + datebar[0] + "\') AND date <= date(\'"
				+ datebar[1] + "\')";
		System.out.println("Searching for: " + sql);

		int count = 0;
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		Tour[] tour = new Tour[count];
		int i = 0;
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

				tour[i] = new Tour(id, name, date, desc, length, language, price, difficultyLevel, ageLimit, area,
						conditions);
				i++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tour;
	}

	/**
	 * Tests the above code
	 * 
	 * @param args
	 */
	
	public static void addTour(Tour[] tour, String name, String address) {
		String url = "jdbc:sqlite:src/Data/daytour.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		int count = 0;
		try (Statement stmt = conn.createStatement()) {
				count++;
				String query = "INSERT INTO BOOKING " + "VALUES (" + count + ", " + tour[0] + ", " + name + ", " + address + ")";
				stmt.executeUpdate(query);
			} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		Search search = new Search();
		int[] pricebar = {0, 20000};

		java.sql.Date[] datebar = new java.sql.Date[2];
		datebar[0] = new java.sql.Date(119, 00, 01);
		datebar[1] = new java.sql.Date(119, 02, 01);

		Tour[] matchingTours = search.getTours("Golden", pricebar, datebar);
		
		System.out.println("Search results: \n");
		for (int i = 0; i < matchingTours.length; i++) {
			System.out.println(matchingTours[i]);
		}
	}

}
