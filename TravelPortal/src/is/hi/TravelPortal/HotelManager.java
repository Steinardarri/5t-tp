package is.hi.TravelPortal;

import java.util.List;

/**
 *
 * @author Olli
 */
public class HotelManager {
    
    private List<Hotel> hotelList;
    
    public List searchForHotels(/*...*/) {
         
        Hotel hotelAK = new Hotel("hotelAK", "Akureyri", 3.8);
        hotelList.add(hotelAK);
        
        return hotelList;
    }
    
    public List getHotelList() {
        return hotelList;
    }
}

