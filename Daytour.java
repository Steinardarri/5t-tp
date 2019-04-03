/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TravelPortal;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Olli
 */
public class Daytour {
    
    private String name;
    private String location;
    private Calendar date;
    private int price;
    
    public Daytour(String daytourName, String daytourLocation, Calendar daytourDate, int daytourPrice) {
        name = daytourName;
        location = daytourLocation;
        date = daytourDate;
        price = daytourPrice;
    }
    
            
    
}
