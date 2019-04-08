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
public class Passenger {
    
    private int passengerNumber;
    private int bookingReference;
    private String name;
    private int[] row;
    private char[] seat;
    private boolean food;
    private boolean ums;
    private boolean freeCancellation;
    

    
    
    public Passenger(int bookingReference, String name, int outboundRow, char outboundSeat, int inboundRow, char inboundSeat, boolean food, boolean ums, boolean freeCancellation) {
        this.passengerNumber = generatePassengerNumber();
        this.bookingReference = bookingReference;
        this.name = name;
        this.row =  makeRowArray(outboundRow, inboundRow);
        this.seat = makeSeatArray(outboundSeat, inboundSeat);
        this.food = food;
        this.ums = ums;
        this.freeCancellation = freeCancellation;
    }
    
    private static int[] makeRowArray(int outboundRow, int inboundRow) {
        int[] temp = {outboundRow, inboundRow};

        return temp;
    }
    
    private static char[] makeSeatArray(char outboundSeat, char inboundSeat) {
        char[] temp = {outboundSeat, inboundSeat};
        
        return temp;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public int getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(int bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getRow() {
        return row;
    }

    public void setRow(int[] row) {
        this.row = row;
    }

    public char[] getSeat() {
        return seat;
    }

    public void setSeat(char[] seat) {
        this.seat = seat;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isUms() {
        return ums;
    }

    public void setUms(boolean ums) {
        this.ums = ums;
    }

    public boolean isFreeCancellation() {
        return freeCancellation;
    }

    public void setFreeCancellation(boolean freeCancellation) {
        this.freeCancellation = freeCancellation;
    }
    
    
    
    private static int generatePassengerNumber() {
        int temp = (int)(Math.random() * 100000000);
        return temp;
    }
    

    
    public static void main(String[] args) {}
    
}
