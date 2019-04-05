/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.TravelPortal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Olli
 */
public class DaytourManager {
    
    private List<Daytour> daytourList = new ArrayList<>();
    
    public List searchForDaytours(/*...*/) {
         
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2019);
        date.set(Calendar.MONTH, 1);
        date.set(Calendar.DATE, 1);
        
        Daytour daytourAK = new Daytour("daytourAK", "Akureyri", date, 20000);
        daytourList.add(daytourAK);
        
        return daytourList;
    }
    
    public List getDaytourList() {
        return daytourList;
    }
    
}
