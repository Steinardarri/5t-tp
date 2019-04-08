// 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throunhugbunadar.pkg5f.pkg2019;
import java.util.Calendar;
import java.util.ArrayList;
/**
 *
 * @author loftureinarsson
 */
public class Search {
    
    /***
     * Searches for flights that meet the search criteria
     * 
     * @param from 
     * @param to 
     * @param startDate
     * @param endDate
     * @return Flight[]
     */
    public static ArrayList<Flight> searchFlight(String from, String to, Calendar startDate, Calendar endDate) {
        ArrayList<Flight> results = Controller.searchFlight(from, to, startDate, endDate);
        
        return (ArrayList)results;
    }
    
    /***
     * Generates random number between 0 and 99999999
     * 
     * @return int
     */
    public static int generateCustomerNumber() {
        int temp = (int)(Math.random()*100000000);
        return temp;
    }
    
    /***
     * Makes a passenger object
     * 
     * @param passengerName
     * @param bookingReference
     * @param row
     * @param seat
     * @param food
     * @param ums
     * @param freeCancellation
     * @return Passenger
     */
    public static Passenger makePassenger(String passengerName, int bookingReference, int outboundRow, char outboundSeat, int inboundRow, char inboundSeat, boolean food, boolean ums, boolean freeCancellation) {
        Passenger temp = new Passenger(bookingReference, passengerName, outboundRow, outboundSeat, inboundRow, inboundSeat, food, ums, freeCancellation);
        
        return temp;
    }
    
    /***
     * Generates random booking reference between 0 and 99999999
     * 
     * @return int
     */
    private static int generateRandomBookingReference() {
        int temp = (int)(Math.random()*100000000);
        
        return temp;
    }
    
    
    /***
     * Books one or two flights with an array of passengers
     * Returns booking reference
     * 
     * @param customerName
     * @param flightInsurance
     * @param ums
     * @param food
     * @param payment
     * @param flights
     * @param passengers
     * @param bookingReference
     * @return int
     */
    public static int bookFlight(int bookingReference, String customerName, String customerEmail, boolean flightInsurance, String payment, ArrayList<Flight> flights, Passenger[] passengers) {
        int customerNumber = 0;
        
        do {
            customerNumber = generateCustomerNumber();     
        } while (Controller.searchCustomerNumber(customerName, customerNumber) == customerNumber);
        
        int statusNumber = Controller.addCustomer(customerName, customerEmail, customerNumber);
        
        if (statusNumber == -1) {
            System.out.println("Customer email already taken");
            return -1;
        }

        
        /*
        int bookingReference = 0;
        do {
            bookingReference = generateBookingReference();
        } while (Controller.searchBooking(bookingReference) == bookingReference);
        */

        Controller.bookFlight(bookingReference, customerNumber, flights, passengers);

        return bookingReference;
    }
    
    
    /***
     * Makes a booking reference
     * Returns a number to use as booking reference
     * 
     * @return int
     */
    public static int makeBookingReference() {
        int bookingReference = 0;
        do {
            bookingReference = generateRandomBookingReference();
        } while (Controller.searchBooking(bookingReference) == bookingReference);
        
        return bookingReference;
    }
    
    
    public static void main(String[] args) { 
        
        Calendar cal = Calendar.getInstance();
        cal.set(2019,2,19);
        ArrayList<Flight> flightResult = searchFlight("Reykjavik", "Akureyri", cal, cal);
        System.out.println("flightResult length " + flightResult.size());
        int bookingReference = makeBookingReference();
        
        Passenger tempPassenger = new Passenger(bookingReference, "Loftur Einarsson", 5, 'b', -1, 'x', true, true, true);
        Passenger tempPassenger2 = new Passenger(bookingReference, "Einar Flókason", 6, 'b', -1, 'x', true, true, true);
        Passenger tempPassenger3 = new Passenger(bookingReference, "Lorem", 9, 'b', -1, 'x', true, true, true);
        Passenger tempPassenger4 = new Passenger(bookingReference, "Ipsum", 11, 'b', -1, 'x', true, true, true);
        Passenger[] passengers = {tempPassenger, tempPassenger2, tempPassenger3, tempPassenger4};
        
        int bookingResult = bookFlight(bookingReference, "Loftur Einarsson", "rutfol@gmail.com", false, "Credit", flightResult, passengers);
        
        /*
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2019,2,25);
        ArrayList<Flight> flightResult2 = searchFlight("Reykjavik", "Akureyri", cal2, cal2);
        System.out.println("flightResult2 length " + flightResult.size());
        
        Passenger tempPassenger5 = new Passenger(bookingReference, "Eitthvað", 5, 'b', 8, 'c', true, true, true);
        Passenger tempPassenger6 = new Passenger(bookingReference, "Svona", 5, 'b', 8, 'c', true, true, true);
        Passenger tempPassenger7 = new Passenger(bookingReference, "Rosa", 5, 'b', 8, 'c', true, true, true);
        Passenger tempPassenger8 = new Passenger(bookingReference, "Gaman", 5, 'b', 8, 'c', true, true, true);
        Passenger[] passengers2 = {tempPassenger5, tempPassenger6, tempPassenger7, tempPassenger8};
        
        int bookingResult2 = bookFlight(bookingReference, "Loftur Einarsson", "rutfol@gmail.com", false, "Credit", flightResult2, passengers2);
        System.out.println(bookingResult2);
        
        Passenger tempPassenger9 = new Passenger(bookingReference, "Hvað", 5, 'b', 8, 'c', true, true, true);
        Passenger tempPassenger10 = new Passenger(bookingReference, "Er", 5, 'b', 8, 'c', true, true, true);
        Passenger tempPassenger11 = new Passenger(bookingReference, "Að Frétta", 5, 'b', 8, 'c', true, true, true);
        Passenger tempPassenger12 = new Passenger(bookingReference, "Væna?", 5, 'b', 8, 'c', true, true, true);
        Passenger[] passengers3 = {tempPassenger9, tempPassenger10, tempPassenger11, tempPassenger12};
        
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2019,2,24);
        System.out.println("cal3 " + cal3.getTime());
        ArrayList<Flight> flightResult3 = searchFlight("Reykjavik", "Akureyri", cal3, cal3);
        System.out.println("flightResult3 length " + flightResult3.size());
        for (int i = 0; i < flightResult3.size(); i++) {
            System.out.println("flightResult3[" + i + "] " + flightResult3.get(i).getId());
        }
        int bookingResult3 = bookFlight(bookingReference, "Ekki Loftur Þorgilsson", "rutfol@gmail.com", false, "Credit", flightResult3, passengers3);
        */
        
        
    }
    
}
