package is.hi.TravelPortal2;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import hotel.Booking;
import hotel.Controller;
import hotel.Hotel;

/**
 *
 * @author Olli
 */

public class HotelManager {
    
    private List<Hotel> hotelList;
    private Controller hc = new Controller();
    
    public List<Hotel> searchForHotels(String name, String city, double rating,int count, Calendar in, Calendar out) {

        return hc.search(name, city, rating,count, in, out);
    }
    
    
    public List bookRoom(Hotel hotel, int[] peopleCount, Calendar inDate, Calendar outDate) {

        List<Booking> hotelBookings = new ArrayList<>();
        
        return hotelBookings;
    }
    
    
    //GETTER&SETTER fyrir hotelList (þarf það?)
    /*
    public List getHotelList() {
        return hotelList;
    }
    
    public void setHotelList(List hotelsList) {
        hotelList = hotelsList;
    }
    */
    
}

