package hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Hotelprufur {
    
    public static List<Hotel> allHotels = new LinkedList<Hotel>();
    public static List<Room[]> someRooms = new LinkedList<Room[]>();
    
    public static void main(String[] args) throws ParseException {
        Room[] roomArray = new Room[5];
        String today = "2019-03-27";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(today));
        for(int i=0;i<5;i++){
            roomArray[i] = new Room(101+i,today,2+i,1000+i*1000);
            System.out.println(roomArray[i].isBooked());
        }
        someRooms.add(roomArray);
        for(int i=1;i<366;i++){
            Room[] next = roomArray;
            c.add(Calendar.DATE, 1);  // number of days to add
            today = sdf.format(c.getTime());
            for (Room r : next) 
                r.setDate(today);
            roomArray=next;
            someRooms.add(roomArray);
        }

        
        c.add(Calendar.DATE, 1);  // number of days to add
        today = sdf.format(c.getTime()); 
        System.out.println(today);
       // Hotel mock = new Hotel();
    }
}
