package is.hi.TravelPortal2;

import throunhugbunadar.pkg5f.pkg2019.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Arrays;

/** 
 *
 * @author Olli
 */
public class FlightManager {
    
    private Search fc = new Search();
    private ArrayList<Flight> flightList = new ArrayList<>();
    
    public ArrayList<Flight> searchForFlights(String from, String to, Calendar startDate, Calendar endDate) {

        //flightList = fc.searchFlight(from, to, startDate, endDate);

        boolean[][] saeti = new boolean[2][2];
        saeti[0][0] = true;

        Flight testFlug = new Flight(100, from, to, "Flugfélag Íslands", startDate, 16, 17, 19, saeti);

        this.flightList.add(testFlug);

        return this.flightList;
    }
    
    //Öll inntök koma frá notanda í gegnum UI
    public int bookFlight(ArrayList<Flight> flights, String[] passengerNames, String customerName, String customerEmail, boolean[] food, boolean[] escort, boolean[] freeCancellation){
        
        boolean flightInsurance = true;
        String payment = "Credit";
        
        int passengerCount = passengerNames.length;
        int bookingReference = fc.makeBookingReference();
        Passenger[] passengers = new Passenger[passengerCount];
        
        //Fyllum passengers fylkið af farþegum sem skráðir eru af notanda
        for(int i = 0; i < passengerCount; i++) {
            passengers[i] = fc.makePassenger(passengerNames[i], bookingReference, -1, 'a', -1, 'a', food[i], escort[i], freeCancellation[i]);
        }
        
        //ÁFRAMHALD: BOOKFLIGHT AÐFERÐ Í FC
        int flightBookingID = fc.bookFlight(bookingReference, customerName, customerEmail, flightInsurance, payment, flights, passengers);
        
        return flightBookingID;
    }
    
    //GETTER&SETTER fyrir flightList (þarf það?)
    /*
    public List getFlightList() {
        return flightList;
    }
    
    public void setFlightList(List flightsList) {
        flightList = flightsList;
    }
    */
}
