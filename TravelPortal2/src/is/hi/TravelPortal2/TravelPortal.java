
package is.hi.TravelPortal2;

import java.time.LocalDate;
import java.util.*;

import throunhugbunadar.pkg5f.pkg2019.*;
import daytour.Tour;
import hotel.Hotel;

/**
 *
 * @author Olli
 */
public class TravelPortal {
    
    private FlightManager fm = new FlightManager();
    private HotelManager hm = new HotelManager();
    private DaytourManager dm = new DaytourManager();
    
    //Pakkar eru byggðir upp þannig að hver pakki inniheldur flug frá staðsetningu A til B, flug til baka(frá B til A), 
    //hótel á staðsetningu B, daytour á staðsetningu B
    public List<Package> searchForPackage(String from, String to, Calendar startDate, Calendar endDate) {
        
        List<Package> packageList = new ArrayList<>();
        
        List<Flight> depFlights = fm.searchForFlights(from, to, startDate, startDate);
        List<Flight> arrFlights = fm.searchForFlights(to, from, endDate, endDate);

        List<Hotel> hotels = hm.searchForHotels("", to, 1.0, 1, startDate, endDate);
        
        int[] pricebar = new int[0];
        Calendar[] datebar = new Calendar[2];
        datebar[0] = startDate;
        datebar[1] = endDate;
        List<Tour> daytours = dm.searchForDaytours("", to, pricebar, datebar);

        
        //ef fjöldi flugferða sem fara frá eða til staðars á tiltekinni dagsetningu sem notandi vill eru núll, 
        //þá eru engir pakkar fyrir sett skilyrði í boði (packageList er þá skilað tómum)
        //einnig gildir að ef fjöldi hótela/daytours í boði á stað sem notandi vill er núll, þá eru engir pakkar fyrir sett skilyrði í boði (packageList er þá skilað tómum)
        if(depFlights.isEmpty() || arrFlights.isEmpty() || hotels.isEmpty() || daytours.isEmpty()) {
            return packageList;
        }
        
        //Annars búum við til lista af pökkum sem allir hafa sömu flugin frá og til áfangastaðar en með mismunandi hótelum og daytours
        else {
            
            //maxIndex þjónar eingöngu þeim tilgangi að passa að ekki sé verið að ítra út fyrir listanna hotels og daytours
            int maxIndex = Math.min(hotels.size(), daytours.size());
        
            for(int i = 0; i < maxIndex; i++) {
                packageList.add(makePackage(depFlights, arrFlights, hotels, daytours, i));
            }
            
            return packageList;
        }
        
        
        
    }
    //Aðferð sem býr til pakka útfrá skilyrðum notanda
    //Þessi aðferð gerir ráð fyrir að það skipti ekki máli hvaða flug fari fram og til baka, heldur AÐ það sé flug sem fer fram og til baka
    public Package makePackage(List<Flight> depFlights, List<Flight> arrFlights, List<Hotel> hotels, List<Tour> daytours, int index) {
        
        Package pack = new Package();
        
        List<Flight> packageFlight = new ArrayList<>();
        packageFlight.add(depFlights.get(0));
        packageFlight.add(arrFlights.get(0));
        List<Hotel> packageHotel = new ArrayList<>();
        packageHotel.add(hotels.get(index));
        List<Tour> packageDaytour = new ArrayList<>();
        packageDaytour.add(daytours.get(index));
        
        pack.addConfirmedFlights(packageFlight);
        pack.addConfirmedHotels(packageHotel);
        pack.addConfirmedDaytours(packageDaytour);
        
        return pack;
    }


    //Pakkabókunarfall ef pakki inniheldur flug fram og til baka, hótel og daytour
    //Inntök fyrir hótelpöntun mjög óljós
    public PackageBooking bookPackage(Package myPackage, String[] passengerNames, String customerName, String customerEmail, String customerAddress, boolean[] food, boolean[] escort, boolean[] freeCancellation, Calendar hotelStartDate, Calendar hotelEndDate) {
        
        PackageBooking booking = new PackageBooking();
        int packageBookingID = generateID();
        
        ArrayList<Flight> flights = myPackage.getConfirmedFlights();
        int flightBookingID = fm.bookFlight(flights, passengerNames, customerName, customerEmail, food, escort, freeCancellation);
        booking.setFlightBookingID(flightBookingID);
        
        Hotel hotel = myPackage.getConfirmedHotels();
        int hotelBookingID = hm.bookRoom(hotel, passengerNames.length, hotelStartDate, hotelEndDate);
        booking.setHotelBookingID(hotelBookingID);
        
        Tour daytour = myPackage.getConfirmedDaytours();
        dm.bookDaytour(daytour, customerName, customerAddress);
        //daytour skilar ekki bookingID svo ekkert verður vistað í packagebooking
        
        booking.setPackageBookingID(packageBookingID);
    }
    
    //Ekki tryggt að packageBookingID verði aldrei það sama, en þetta er nóg fyrir það sem við þurfum að nota það í
    public int generateID() {
        return (int)(Math.random()*1000000);
    }
}


    public List<Flight> leitaFlug(LocalDate dep, LocalDate arr, String from, String to) {

        Calendar cdep = Calendar.getInstance();
        cdep.set(dep.getYear(), dep.getMonthValue()-1, dep.getDayOfMonth());
        System.out.println("dep = " + dep.getYear() + " " + dep.getMonthValue() + " -1 " + dep.getDayOfMonth());
        Calendar carr = Calendar.getInstance();
        carr.set(arr.getYear(), arr.getMonthValue()-1, arr.getDayOfMonth());

        return fm.searchForFlights(from, to, cdep, carr);
    }

    public List<Tour> leitaDaytour() {
        List<Tour> tours = new ArrayList<>();
        Tour t = new Tour(10, "Ferð", new Date(), "ferð", 3, "íslenska", 1000, 5,
        18, "Reyk", "gott");
        tours.add(t);
        return tours;
    }

}
