package is.hi.TravelPortal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import throunhugbunadar.pkg5f.pkg2019.Flight;

/**
 *
 * @author Olli
 */
public class TravelPortalTest {/*
    
    public TravelPortalTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of searchForPackage method, of class TravelPortal.
     */
    /*
    @Test
    public void testSearchForPackage() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.YEAR, 2019);
        startDate.set(Calendar.MONTH, 1);
        startDate.set(Calendar.DATE, 1);
        
        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.YEAR, 2019);
        endDate.set(Calendar.MONTH, 1);
        endDate.set(Calendar.DATE, 10);
        
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2019);
        date.set(Calendar.MONTH, 1);
        date.set(Calendar.DATE, 1);
        
        Flight RVKAK = new Flight("Reykjavík", "Akureyri", startDate);
        Flight AKRVK = new Flight("Akureyri", "Reykjavík", endDate);
        Hotel hotelAK = new Hotel("hotelAK", "Akureyri", 3.8);
        Daytour daytourAK = new Daytour("daytourAK", "Akureyri", date, 20000);
        
        List<Flight> packageFlight = new ArrayList<>();
        packageFlight.add(RVKAK);
        packageFlight.add(AKRVK);
        List<Hotel> packageHotel = new ArrayList<>();
        packageHotel.add(hotelAK);
        List<Daytour> packageDaytour = new ArrayList<>();
        packageDaytour.add(daytourAK);
        
        Package minnPakki = new Package();
        minnPakki.setConfirmedFlights(packageFlight);
        minnPakki.setConfirmedHotels(packageHotel);
        minnPakki.setConfirmedDaytours(packageDaytour);
        
        List<Package> packageList = new ArrayList<>();
        packageList.add(minnPakki);
        
        System.out.println("searchForPackage");
        String from = "Reykjavík";
        String to = "Akureyri";
        TravelPortal instance = new TravelPortal();
        List<Package> expResult = packageList;
        List<Package> result = instance.searchForPackage(from, to, startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    
}
