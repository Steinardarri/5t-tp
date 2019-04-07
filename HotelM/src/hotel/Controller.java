package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Notandi
 */
public class Controller {

   public static List search(int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h: all){
            if(isRoomFree(h.getId(),count,in,out))
                result.add(h);
        }
        return result;
    }
    
    public static List search(String name, int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h:all){
            if((h.getName().equalsIgnoreCase(name) || 
                    h.getCity().equalsIgnoreCase(name))&&
                    isRoomFree(h.getId(),count,in,out)){
                result.add(h);
            }
        }
        return result;
    }
    
    
    public static List search(double rating,int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h:all){
            if((h.getRating()<rating+0.5 && h.getRating()>rating-0.5) &&
                    isRoomFree(h.getId(),count,in,out))
                result.add(h);
        }      
        return result;
    }
    
    public static List search(String name, double rating,int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h:all){
            if((h.getRating()<rating+0.5 && h.getRating()>rating-0.5) &&
                    (h.getName().equalsIgnoreCase(name) || 
                    h.getCity().equalsIgnoreCase(name)) &&
                    isRoomFree(h.getId(),count,in,out))
                result.add(h);
        }      
        return result;
    }
        
        
    
    public static List search(String name, String city, double rating,int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h:all){
            if((h.getRating()<rating+0.5 && h.getRating()>rating-0.5) &&
                    h.getName().equalsIgnoreCase(name) && 
                    h.getCity().equalsIgnoreCase(name) &&
                    isRoomFree(h.getId(),count,in,out))
                result.add(h);
        }      
        return result;    
    }     List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h: all){
            if(isRoomFree(h.getId(),count,in,out))
                result.add(h);
        }
        return result;
    }
    
    public static List search(String name, int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h:all){
            if((h.getName().equalsIgnoreCase(name) || 
                    h.getCity().equalsIgnoreCase(name))&&
                    isRoomFree(h.getId(),count,in,out)){
                result.add(h);
            }
        }
        return result;
    }
    
    
    public static List search(double rating,int count, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        List result = new LinkedList();
        for(Hotel h:all){
            if((h.getRating()<rating+0.5 && h.getRating()>rating-0.5) &&
                    isRoomFree(h.getId(),count,in,out))
                result.add(h);
        }      
        return result;
    }
        
        
    
    public static List search(String name, String city, double rating,int count, Calendar in, Calendar out){
        return new LinkedList();
    }
    
//    public static List getHotelbyRating(double rating){
//        Connection con;
//        Statement stat;
//        ResultSet res;     
//        String selRat = "Select * from App.Hotel where rating ="+rating;    
//        
//        List<Hotel> all=Hotelprufur.allHotels;
//        List result = null;
//        try{
//            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelDB");
//            stat = con.createStatement();
//            res = stat.executeQuery(selRat);
//            while(res.next()){
//                result = new LinkedList();
//                int id = res.getInt("ID");
//                String name = res.getString("Name");
//                String city = res.getString("City");
//                Double rat = res.getDouble("Rating");
//                List<Room[]> rooms;
//                rooms = (List<Room[]>) res.getObject("Rooms");
//                Hotel newHotel = new Hotel(id,name,city,rat,rooms);
//                result.add(newHotel);
//            }
//           
//        } catch(SQLException e){
//            e.printStackTrace();
//        }
//        return result;
//        
//    }
    
    public static boolean isRoomFree(int hotelId, int peopleCount, Calendar in, Calendar out){
        List<Hotel> all=Hotelprufur.allHotels;
        for(Hotel h:all){
            if(h.getId()==hotelId){
                return h.isFreeRoom(hotelId,peopleCount,in,out);
            }
        }
        return false;
    }
   
    public static Booking book(Calendar in, Calendar out, int guest_id,List<Room> room){
        Booking b = new Booking((int)(Math.random()*1000),in,out,guest_id);
        for(Room r: room){
            r.setBooked(true);
        }
        return b;
    }    
}
