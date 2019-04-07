/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    
    
    public List searchForHotels(String name, String location, Calendar date, double rating) {
         
        hotelList = hc.search(name, location, date, rating);
        return hotelList;
    }
    
    
    public List bookRoom(List<Hotel> hotelList, int[] peopleCount, Calendar[] startDate, Calendar[] endDate) {
        
        int hotelCount = hotelList.size();
        List<hotelBooking> hotelBookings = new ArrayList<>();
        
        for(int i = 0; i < hotelCount; i++) {
            hotel = hotelList.get(i);
            hotelBookings.add(hc.bookRoom(hotel.getHotelID, peopleCount[i], startDate[i], endDate[i]));
        }
        
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

