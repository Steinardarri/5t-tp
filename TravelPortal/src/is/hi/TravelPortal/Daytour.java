package is.hi.TravelPortal;

import java.util.Calendar;

/**
 *
 * @author Olli
 */
public class Daytour {
    
    private String name;
    private String location;
    private Calendar date;
    private int price;
    
    public Daytour(String daytourName, String daytourLocation, Calendar daytourDate, int daytourPrice) {
        name = daytourName;
        location = daytourLocation;
        date = daytourDate;
        price = daytourPrice;
    }
}
