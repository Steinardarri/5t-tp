/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throunhugbunadar.pkg5f.pkg2019;

/**
 *
 * @author loftureinarsson
 */
public class Booking {
    
    private int bookingRef;
    private String flightNr;
    private String payMethod;
    private int customerSsn;
    private boolean accompChild;
    private String customerName;
    private String[] seat;
    private boolean food;
    private boolean freeCancellation;
    
    public Booking(int bookingRef, String flightNr, String payMethod, int customerSsn, boolean accompChild, String customerName, String[] seat, boolean food, boolean freeCancellation) {
        this.bookingRef = bookingRef;
        this.flightNr = flightNr;
        this.payMethod = payMethod;
        this.customerSsn = customerSsn;
        this.accompChild = accompChild;
        this.customerName = customerName;
        this.seat = seat;
    }
    
    public static void main() { }
    
    
    
}
