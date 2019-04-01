package is.hi.TravelPortal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagerTest {
    private FlightManager fm;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fm = new FlightManager();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        fm = null;
    }

    @org.junit.jupiter.api.Test
    void testSearchForFlights() {
        List utkomuFlug;
        String from = "London";
        String to = "Reykjavik";

        // Greum calander hlut fyrir dagsetningu
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.APRIL);
        cal.set(Calendar.DAY_OF_MONTH, 26);
        cal.set(Calendar.YEAR, 2019);
        // leitunar aðferðin krefst Date
        Date date = new Date(cal.getTimeInMillis());
        // Date þarf millisekúndur frá 1. jan 1970 til að setja dag

        utkomuFlug = fm.searchForFlights(from, to, date);

        assertNotNull(utkomuFlug.get(0));
    }
}