package TravelPortal;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Olli
 */



public class HotelManager {
    
    private List<Hotel> hotelList;
    private HotelController hc = new HotelController();
    
    
    
    public ArrayList<Hotel> searchForHotels(String name, String location, Calendar date, double rating) {
         
        hotelList = hc.search(name, location, date, rating);
        return hotelList;
    }
    
    
    public int bookRoom(Hotel hotel, int peopleCount, Calendar startDate, Calendar endDate) {
        
        Booking hotelBooking = new Booking();
        
        hotelBooking = hc.bookRoom(hotel.getHotelID, peopleCount, startDate, endDate);
        int hotelBookingID = hotelBooking.getId();
        
        return hotelBookingID;
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
