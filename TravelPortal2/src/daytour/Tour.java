package daytour;

import java.util.Date;

public class Tour {
	public int id;
	public String name;
	public Date date;
	public String desc;
	public int length;
	public String language;
	public int price;
	public int difficultyLevel;
	public int ageLimit;
	public String area;
	public String conditions;

	/**
	 * Initializes a Tour object
	 */
	public Tour(int id, String name, Date date, String desc, int length, String language, int price, int difficultyLevel,
			int ageLimit, String area, String conditions) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.desc = desc;
		this.length = length;
		this.language = language;
		this.price = price;
		this.difficultyLevel = difficultyLevel;
		this.ageLimit = ageLimit;
		this.area = area;
		this.conditions = conditions;
	}
	
	/**
	 * Enables printing out Tour object details with System.out.println()
	 */
	public String toString() {
		return "Tour ID:          " + id + 
				"\nName:             " + name +
				"\nDate:             " + date +
				"\nDesc:             " + desc +
				"\nLength:           " + length +
				"\nLanguage:         " + language +
				"\nPrice:            " + price +
				"\nDifficulty level: " + difficultyLevel + 
				"\nAge limit:        " + ageLimit +
				"\nArea:             " + area + 
				"\nConditions:       " + conditions + "\n";
	}
	
	/**
	 * Tests the above code
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Date today = new Date();
		Tour tour = new Tour(1, "TourA", today, "???", 180, "English", 10000, 2, 18, "Reykjav�k", "Cold");
		Tour tour2 = new Tour(1, "TourB", today, "???", 180, "Icelandic", 10000, 2, 18, "Reykjav�k", "Freezing");
		System.out.println(tour);
		System.out.println(tour2);
	}

}
