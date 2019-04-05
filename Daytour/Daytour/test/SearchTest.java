import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SearchTest {
	Tour[] tour1, tour2, tour3;
	
	@BeforeEach
	void setUp() throws Exception {
		Search search = new Search();
		int[] pricebar = {0, Integer.MAX_VALUE};
		
		java.sql.Date[] datebar = new java.sql.Date[2];
		datebar[0] = new java.sql.Date(00, 00, 01); // 1900.01.01
		datebar[1] = new java.sql.Date(200, 00, 01); // 2100.01.01
		
		
		//Search for tours with the string "Circle" in their name
		tour1 = search.getTours("Circle", pricebar, datebar);
		
		//Search for tours with prices between 4000 and 5000
		pricebar[0] = 4000;
		pricebar[1] = 5000;
		tour2 = search.getTours("", pricebar, datebar);
		
		//Search for tours with dates between 2019.02.01 and 2019.03.01
		datebar[0] = new java.sql.Date(119, 01, 01);
		datebar[1] = new java.sql.Date(119, 02, 01);
		pricebar[0] = 0;
		pricebar[1] = Integer.MAX_VALUE;
		tour3 = search.getTours("", pricebar, datebar);
	}

	@AfterEach
	void tearDown() throws Exception {
		tour1 = null;
		tour2 = null;
		tour3 = null;
	}

	/*
	 * Testing search results (with expected values from daytour.db in testData folder)
	 */
	@Test
	void testStringSearch() {
		assertEquals(2, tour1.length);
		assertEquals(1, tour1[0].id);
		assertEquals(3, tour1[1].id);
	}
	
	@Test
	void testPriceSearch() {
		assertEquals(1, tour2.length);
		assertEquals(2, tour2[0].id);
	}
	
	@Test
	void testDateSearch() {
		assertEquals(1, tour3.length);
		assertEquals(3, tour3[0].id);
	}
	
	/*
	 * Testing if object attributes are retrievable through getters
	 */
	@Test
	void testName() {
		assertEquals("Golden Circle Classic Day Trip from Reykjavik", tour1[0].name);
	}
	
	@Test
	void testDate() {
		java.util.Date date = new java.util.Date(119, 00, 01); 
		assertEquals(date, tour1[0].date);
	}
	
	@Test
	void testDesc() {
		assertEquals("asdf", tour1[0].desc);
	}
	
	@Test
	void testLength() {
		assertEquals(3, tour1[0].length);
	}
	
	@Test
	void testLanguage() {
		assertEquals("English", tour1[0].language);
	}
	
	@Test
	void testPrice() {
		assertEquals(5700, tour1[0].price);
	}
	
	@Test
	void testDifficultyLevel() {
		assertEquals(1, tour1[0].difficultyLevel);
	}
	
	@Test
	void testAgeLimit() {
		assertEquals(0, tour1[0].ageLimit);
	}
	
	@Test
	void testArea() {
		assertEquals("Reykjavik", tour1[0].area);
	}
	
	@Test
	void testConditions() {
		assertEquals("Cold", tour1[0].conditions);
	}
	
}
