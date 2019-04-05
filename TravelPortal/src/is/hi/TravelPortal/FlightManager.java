package is.hi.TravelPortal;

import java.util.List;
import java.util.Calendar;

/** 
 *
 * @author Olli
 */
public class FlightManager {
    
    //private FlightController fc = new FlightController();
    //private List<Flight> flightList;
    //private Flight[] flights;
    
    private List<Flight> depFlights;
    private List<Flight> arrFlights;
    
    
    public List searchForFlights(String from, String to, Calendar date) {
         
        /*flights = fc.searchFlights(from, to, date); 
        List<Flight> flightList = Arrays.asList(flights);
        return flightList;*/
        
        //TEST
        Calendar departure = Calendar.getInstance();
        departure.set(Calendar.YEAR, 2019);
        departure.set(Calendar.MONTH, 1);
        departure.set(Calendar.DATE, 1);
        
        Calendar arrival = Calendar.getInstance();
        arrival.set(Calendar.YEAR, 2019);
        arrival.set(Calendar.MONTH, 1);
        arrival.set(Calendar.DATE, 10);
        
        Flight RVKAK = new Flight("Reykjavík", "Akureyri", departure);
        Flight AKRVK = new Flight("Akureyri", "Reykjavík", arrival);
        
        depFlights.add(RVKAK);
        arrFlights.add(AKRVK);
        
        return depFlights;
    }
    
    public List getdepFlightList() {
        return depFlights;
    }
    public List getarrFlightList() {
        return arrFlights;
    }
    /*
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
