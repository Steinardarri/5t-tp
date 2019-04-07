/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Calendar getDeparture() {
        return departure;
    }
    
    public Calendar getArrival() {
        return arrival;
    }
    
    
    //SETTERS
    public void addConfirmedFlights(ArrayList<Flight> flights) {
        confirmedFlights.addAll(flights);
    }
    
    public void addConfirmedHotels(ArrayList<Hotel> hotels) {
        confirmedHotels.addAll(hotels);
    }
    
    public void addConfirmedDaytours(ArrayList<Tour> daytours) {
        confirmedDaytours.addAll(daytours);
    }
    
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
    
    public void setDeparture(Calendar depart) {
        departure = depart;
    }
    
    public void setArrival(Calendar arriv) {
        arrival = arriv;
    }
}
