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
public class Package {

    private ArrayList<Flight> confirmedFlights = new ArrayList<>();
    private ArrayList<Hotel> confirmedHotels = new ArrayList<>();
    private ArrayList<Tour> confirmedDaytours = new ArrayList<>();
    private int totalPrice;
    private Calendar departure;
    private Calendar arrival;
    private PackageBooking packageBooking;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    //GETTERS
    public List getConfirmedFlights(){
        return confirmedFlights;
    }
    
    public List getConfirmedHotels(){
        return confirmedHotels;
    }
    
    public List getConfirmedDaytours(){
        return confirmedDaytours;
    }
    
    public PackageBooking getPackageBooking() {
        return packageBooking;
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }
    
    public Calendar getDeparture() {
        return departure;
    }
    
    public Calendar getArrival() {
        return arrival;
    }
    
    
    
    public void addConfirmedFlights(ArrayList<Flight> flights) {
        confirmedFlights.addAll(flights);
    }
    
    public void addConfirmedHotels(ArrayList<Hotel> hotels) {
        confirmedHotels.addAll(hotels);
    }
    
    public void addConfirmedDaytours(ArrayList<Tour> daytours) {
        confirmedDaytours.addAll(daytours);
    }
    
    //Þessi aðferð sóar minni eins og er, þyrfti að uppfæra
    public Package clearPackage(Package myPackage) {
        Package clearPackage = new Package();
        
        return clearPackage;
    }
    
    //SETTERS
    public void setConfirmedFlights(ArrayList<Flight> flights) {
        confirmedFlights = flights;
    }
    
    public void setConfirmedHotels(ArrayList<Hotel> hotels) {
        confirmedHotels = hotels;
    }
    
    public void setConfirmedDaytours(ArrayList<Tour> daytours) {
        confirmedDaytours = daytours;
    }
    
    public void setPackageBooking(PackageBooking packBook) {
        packageBooking = packBook;
    }
    
    public void setTotalPrice(int price) {
        totalPrice = price;
    }
    
    public void setDeparture(Calendar depart) {
        departure = depart;
    }
    
    public void setArrival(Calendar arriv) {
        arrival = arriv;
    }
}
