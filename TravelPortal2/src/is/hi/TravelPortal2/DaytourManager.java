package is.hi.TravelPortal2;

import daytour.Tour;
import daytour.Search;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Olli
 */
public class DaytourManager {
    
    private ArrayList<Tour> daytourList = new ArrayList<>();
    private Search dc = new Search();
    
    /**
    * Search for Tours from database with matching name, price, date and location
    * 
    * @param searchInput
    * @param location
    * @param pricebar   (price range from pricebar[0] to pricebar[1])
    * @param datebar    (date range from datebar[0] to datebar[1])
    * @return resulting tours as ArrayList of objects
    */
    public ArrayList<Tour> searchForDaytours(String searchInput, String location, int[] pricebar, Calendar[] datebar) {
         
        daytourList = dc.getTours(searchInput, location, pricebar, datebar);
        return daytourList;
    }
    
    public void bookDaytour(ArrayList<Tour> daytourList, String customerName, String customerAddress) {
        
        int daytourCount = daytourList.size();
        
        for(int i = 0; i < daytourCount; i++) {
            dc.addTour(daytourList.get(i), customerName, customerAddress);
        }
    }
    
    //GETTER&SETTER fyrir daytourList (þarf það?)
    /*
    public List getDaytourList() {
        return daytourList;
    }
    
    public void setDaytourList(List daytoursList) {
        daytourList = daytoursList;
    }
    */
    
}
