/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throunhugbunadar.pkg5f.pkg2019;
import java.util.Calendar;
/**
 *
 * @author loftureinarsson
 */
public class Flight {
    
    private int verd;
    private String fra;
    private String til;
    private String flugfelag;
    private Calendar dagsetning;
    private int fjoldiFarthega;
    private int brottfor;
    private int koma;
    private int id;
    private Airplane airplane;
    
    public Flight(int verd, String fra, String til, String flugfelag, Calendar dagsetning, int brottfor, int koma, int id, boolean[][] seats) {
        this.verd = verd;
        this.fra = fra;
        this.til = til;
        this.flugfelag = flugfelag;
        this.dagsetning = dagsetning;
        //this.fjoldiFarthega = fjoldiFarthega;
        this.brottfor = brottfor;
        this.koma = koma;
        this.id = id;
        this.airplane = new Airplane(seats);
    }

    public int getVerd() {
        return verd;
    }

    public void setVerd(int verd) {
        this.verd = verd;
    }

    public String getFra() {
        return fra;
    }

    public void setFra(String fra) {
        this.fra = fra;
    }

    public String getTil() {
        return til;
    }

    public void setTil(String til) {
        this.til = til;
    }

    public String getFlugfelag() {
        return flugfelag;
    }

    public void setFlugfelag(String flugfelag) {
        this.flugfelag = flugfelag;
    }

    public Calendar getDagsetning() {
        return dagsetning;
    }

    public void setDagsetning(Calendar dagsetning) {
        this.dagsetning = dagsetning;
    }

    public int getFjoldiFarthega() {
        return fjoldiFarthega;
    }

    public void setFjoldiFarthega(int fjoldiFarthega) {
        this.fjoldiFarthega = fjoldiFarthega;
    }

    public int getBrottfor() {
        return brottfor;
    }

    public void setBrottfor(int brottfor) {
        this.brottfor = brottfor;
    }

    public int getKoma() {
        return koma;
    }

    public void setKoma(int koma) {
        this.koma = koma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public static void main(String[] args) { } 
    
}
