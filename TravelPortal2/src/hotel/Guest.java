package hotel;

/**
 *
 * @author Notandi
 */

public class Guest {
    private int id;
    private String name;

    public Guest(int id, String name){
       this.id=id;
       this.name=name;  
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int SSn) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
