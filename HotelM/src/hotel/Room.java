package hotel;

/**
 *
 * @author Notandi
 */
public class Room {
    private int nr;
    private String date;
    private boolean booked;
    private int capacity; //how many people can stay in the room (max)
    private int price; //per night
    
    public Room(int nr,String date,int capacity,int price){
        this.nr=nr;
        this.date=date;
        this.capacity=capacity;
        this.price=price;
    }
    
    public void book() throws Exception{
        if(this.isBooked()){
            throw new Exception("Herbergi núþegar bókað");
        }else{
            this.setBooked(true);
        }
        
    }

    public int getNr() {
        return nr;
    }

    public String getDate(){
        return date;
    }

    public boolean isBooked() {
        return booked;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }



    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}


