/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TravelPortal;
import java.util.List;
import java.util.Date;



/**
 *
 * @author Olli
 */
public class Package {

    private List confirmedFlights;
    private List confirmedHotels;
    private List confirmedDaytours;
    private int totalPrice;
    private Date departure;
    private Date arrival;
    private int packageBookingID;
    
    
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
    
    public int getPackageBookingID() {
        return packageBookingID;
    }
    
    public int getTotalPrice() {
        return totalPrice;
    }
    
    public Date getDeparture() {
        return departure;
    }
    
    public Date getArrival() {
        return arrival;
    }
    
    
    //SETTERS
    public void setConfirmedFlights(List Flights) {
        confirmedFlights = Flights;
    }
    
    public void setConfirmedHotels(List Hotels) {
        confirmedHotels = Hotels;
    }
    
    public void setConfirmedDaytours(List Daytours) {
        confirmedDaytours = Daytours;
    }
    
    public void setPackageBookingID(int ID) {
        packageBookingID = ID;
    }
    
    public void setTotalPrice(int price) {
        totalPrice = price;
    }
    
    public void setDeparture(Date depart) {
        departure = depart;
    }
    
    public void setArrival(Date arriv) {
        arrival = arriv;
    }
}
