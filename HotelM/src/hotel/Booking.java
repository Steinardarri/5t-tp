package hotel;

import java.util.Calendar;

/**
 *
 * @author Notandi
 */
public class Booking {
    private int id;
    private Calendar inDate;
    private Calendar outDate;
    private int guest_id;
   
    public Booking(int id, Calendar inDate, Calendar outDate, int guest_id){
        this.id=id;
        this.inDate=inDate;
        this.outDate=outDate;
        this.guest_id=guest_id;
    }
   
    public int getId() {
        return id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public Calendar getInDate() {
        return inDate;
    }

    public Calendar getOutDate() {
        return outDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }
    
}
