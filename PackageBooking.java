package TravelPortal;

import Daytour.*;
import throunhugbunadar.pkg5f.pkg2019.*;
//import hotelpakki;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;



/**
 *
 * @author Olli
 */
public class PackageBooking {

    private int hotelBookingID;
    private int flightBookingID;
    private int daytourBookingID;
    private int packageBookingID;
    
   
    
    
    //GETTERS
    public int getFlightBookingID(){
        return flightBookingID;
    }
    
    public int getHotelBookingID(){
        return hotelBookingID;
    }
    
    public int geDaytourBookingID(){
        return daytourBookingID;
    }
    
    public int getPackageBookingID() {
        return packageBookingID;
    }
    
    //SETTERS
    public void setFlightBookingID(int flightID) {
        flightBookingID = flightID;
    }
    
    public void setHotelBookingID(int hotelID) {
        hotelBookingID = hotelID;
    }
    
    public void setDaytourBookingID(int daytourID) {
        daytourBookingID = daytourID;
    }
    
    public void setPackageBookingID(int packageID) {
        packageBookingID = packageID;
    }
    
}
