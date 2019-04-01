/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.TravelPortal;
import java.util.List;
import java.util.Date;
import java.util.Arrays;

/** 
 *
 * @author Olli, Steinar
 */
public class FlightManager {
    
    private FlightController fc = new FlightController();
    private List flightList;
    private Flight[] flights;
    
    
    
    public List searchForFlights(String from, String to, Date date) {
         
        flights = fc.searchFlights(from, to, date); 
        List<Flight> flightList = Arrays.asList(flights);
        return flightList;
    }
    
    //Öll inntök koma frá notanda í gegnum UI
    public int bookFlight(Flight[] flights, String[] passengerNames, int[] row, char[] seat, boolean[] food, boolean[] escort, boolean[] freeCancellation){
        
        int passengerCount = passengerNames.length;
        int bookingReference = fc.makeBookingReference();
        Passenger[] passengers = new Passenger[passengerCount];
        
        //Fyllum passengers fylkið af farþegum sem skráðir eru af notanda
        for(int i = 0; i < passengerCount; i++) {
            passengers[i] = fc.makePassenger(passengerNames[i], bookingReference, row[i], seat[i], food[i], escort[i], freeCancellation[i]);
        }
        
        //ÁFRAMHALD: BOOKFLIGHT AÐFERÐ Í FC
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
