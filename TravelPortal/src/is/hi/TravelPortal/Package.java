/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.TravelPortal;

import daytour.Tour;
import throunhugbunadar.pkg5f.pkg2019.*;
import hotel.Hotel;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Olli
 */
public class Package {

    private List<Flight> confirmedFlights = new ArrayList<>();
    private List<Hotel> confirmedHotels = new ArrayList<>();
    private List<Tour> confirmedDaytours = new ArrayList<>();
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
    public void addConfirmedFlights(List<Flight> flights) {
        confirmedFlights.addAll(flights);
    }

    public void addConfirmedHotels(List<Hotel> hotels) { confirmedHotels.addAll(hotels); }

    public void addConfirmedDaytours(List<Tour> daytours) {
        confirmedDaytours.addAll(daytours);
    }
    
    public void setConfirmedFlights(List<Flight> Flights) {
        confirmedFlights = Flights;
    }
    
    public void setConfirmedHotels(List<Hotel> Hotels) {
        confirmedHotels = Hotels;
    }
    
    public void setConfirmedDaytours(List<Tour> Daytours) {
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
