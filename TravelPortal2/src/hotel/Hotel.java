package hotel;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Notandi
 */
public class Hotel {
    
    private int id;
    private String name;
    private String city;
    private double rating;
    private List<Room[]> rooms;
    private List<Booking> bookings;
    
    public Hotel(int id,String name,String city,double rating,List<Room[]> rooms){
        this.id=id;
        this.name=name;
        this.city=city;
        this.rating=rating;
        this.rooms=rooms;
        bookings=new LinkedList<>();
    }
    
    public boolean isFreeRoom(int hotelId, int peopleCount, Calendar in, Calendar out){
        
        return false;
    }
    
    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getRating() {
        return rating;
    }

    public List<Room[]> getRooms() {
        return rooms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setRooms(List<Room[]> rooms) {
        this.rooms = rooms;
    }
    
}
