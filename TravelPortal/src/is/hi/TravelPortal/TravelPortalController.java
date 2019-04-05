package is.hi.TravelPortal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelPortalController {

    // Managerar
    private FlightManager fm = new FlightManager();
    private HotelManager hm = new HotelManager();
    private DaytourManager dtm = new DaytourManager();

    private List<Package> packageList = new ArrayList<>();

    public List<Flight> selectedFlights = new ArrayList<>();
    public List<Hotel> selectedHotels = new ArrayList<>();
    public List<Daytour> selectedDaytours = new ArrayList<>();


    public List<Package> searchForPackage(Date startDate, Date endDate,
                                 int lowerPrice, int upperPrice, String location) {
        List<Package> pakkar = new ArrayList<>();
        
        return pakkar;
    }
    
    public Package createPackage(List<Flight> flug,List<Hotel> hotel,List<Daytour> ferdir){



        Package pakki = new Package();

        return pakki;
    }
}
