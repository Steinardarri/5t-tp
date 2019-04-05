package is.hi.TravelPortal;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Olli
 */
public class TravelPortalController {


    private FlightManager fm = new FlightManager();
    private HotelManager hm = new HotelManager();
    private DaytourManager dm = new DaytourManager();

    //Pakkar eru byggðir upp þannig að hver pakki inniheldur flug frá staðsetningu A til B, flug til baka(frá B til A),
    //hótel á staðsetningu B, daytour á staðsetningu B
    public List<Package> searchForPackage(String from, String to, Calendar startDate, Calendar endDate) {

        //ArrayList<Package> packageList = new ArrayList<Package>();

        List<Package> packageList = new ArrayList<>();

        List<Flight> arrFlights = fm.getarrFlightList();
        List<Flight> depFlights = fm.getdepFlightList();
        List<Hotel> hotels = hm.getHotelList();
        List<Daytour> daytours = dm.getDaytourList();

        /*
        List<Flight> depFlights = fm.searchForFlights(from, to, startDate);
        List<Flight> arrFlights = fm.searchForFlights(to, from, endDate);

        List<Hotel> hotels = hm.searchForHotels(hotelName, to, rating);//SKOÐA INNTÖK - Væri ekki gott að hafa Calendar inntak í þessa aðferð? Hvað ef við viljum hafa inntak autt?
        List<Daytour> daytours = dm.searchForDaytours(daytourName, daytourPrice, startDate);//SKOÐA INNTÖK - Væri ekki gott að hafa location inntak í þessa aðferð?
        */

        //maxIndex þjónar eingöngu þeim tilgangi að passa að ekki sé verið að ítra út fyrir listanna hotels og daytours
        int maxIndex = Math.min(hotels.size(), daytours.size());

        //ef fjöldi flugferða sem fara frá eða til staðars á tiltekinni dagsetningu sem notandi vill eru núll,
        //þá eru engir pakkar fyrir sett skilyrði í boði (return null)
        //einnig gildir að ef fjöldi hótela í boði á stað sem notandi vill er núll, þá eru engir pakkar fyrir sett skilyrði í boði (return null)
        if(depFlights.isEmpty() || arrFlights.isEmpty() || hotels.isEmpty()) {
            return null;
        }
        //Annars búum við til lista af pökkum sem allir hafa sömu flugin frá og til áfangastaðar en með mismunandi hótelum og daytours
        else {
            for(int i = 0; i < maxIndex; i++) {
                packageList.add(makePackage(depFlights, arrFlights, hotels, daytours, i));
            }

            return packageList;
        }



    }
    //Aðferð sem býr til pakka útfrá skilyrðum notanda
    //Þessi aðferð gerir ráð fyrir að það skipti ekki máli hvaða flug fari fram og til baka, heldur AÐ það sé flug sem fer fram og til baka
    public Package makePackage(List<Flight> depFlights, List<Flight> arrFlights, List<Hotel> hotels, List<Daytour> daytours, int index) {

        Package pakki = new Package();

        List<Flight> packageFlight = Arrays.asList(depFlights.get(0), arrFlights.get(0));
        List<Hotel> packageHotel = Arrays.asList(hotels.get(index));
        List<Daytour> packageDaytour = Arrays.asList(daytours.get(index));

        pakki.setConfirmedFlights(packageFlight);
        pakki.setConfirmedHotels(packageHotel);
        pakki.setConfirmedDaytours(packageDaytour);

        return pakki;
    }
}
