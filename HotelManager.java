/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TravelPortal;

import TravelPortal.Hotel;
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
    
    public List searchForHotels(/*...*/) {
         
        Hotel hotelAK = new Hotel("hotelAK", "Akureyri", 3.8);
        hotelList.add(hotelAK);
        
        return hotelList;
    }
    
    public List getHotelList() {
        return hotelList;
    }
    
}

