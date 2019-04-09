package is.hi.TravelPortal2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.time.LocalDate;
import javafx.fxml.Initializable;

import throunhugbunadar.pkg5f.pkg2019.*;
import daytour.Tour;
import hotel.Hotel;

public class TravelPortalController implements Initializable {

    private TravelPortal tp;

    @FXML
    private TextArea errorArea;

    // Flug inntök
    @FXML
    private TextField flightFrom;
    @FXML
    private TextField flightTo;
    @FXML
    private DatePicker flightDep;
    @FXML
    private DatePicker flightArr;

    // Hótel inntök
    @FXML
    private DatePicker hotelIn;
    @FXML
    private DatePicker hotelOut;
    @FXML
    private TextField hotelCity;
    @FXML
    private TextField hotelStars;

    // Daytour  inntök
    @FXML
    private TextField tourArea;
    @FXML
    private DatePicker tourFrom;
    @FXML
    private DatePicker tourTo;

    // Listar
    @FXML
    private ListView<String> searchedFlights;
    private ObservableList<String>  flugListi;
    @FXML
    private ListView<Hotel> searchedHotels;
    @FXML
    private ListView<Tour> searchedDaytours;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tp = new TravelPortal();
        System.out.println("test1");
        flugListi = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        searchedFlights = new ListView<>();
        searchedFlights.setItems(flugListi);
        searchedDaytours = new ListView<>();
    }

    @FXML
    public void leitaFlugHandler(ActionEvent event) {
        try {
            LocalDate dep = flightDep.getValue();
            LocalDate arr = flightArr.getValue();
            String from = flightFrom.getText();
            String to = flightTo.getText();

            List<Flight> flug = tp.leitaFlug(dep, arr, from, to);
            ObservableList<Flight> obl = FXCollections.observableArrayList(flug);
            searchedFlights.setItems(obl);
        } catch (Exception e) {
            errorArea.setText("Villa: " + e);
        }

    }

    @FXML
    private void leitaHotelHandler(ActionEvent event) {
        LocalDate in = hotelIn.getValue();
        LocalDate out = hotelOut.getValue();
        String city = hotelCity.getText();
        int stars = Integer.parseInt(hotelStars.getText());


    }

    @FXML
    private void leitaDaytourHandler(ActionEvent event) {
        try {
            String area = tourArea.getText();
            LocalDate from = tourFrom.getValue();
            LocalDate to = tourTo.getValue();

            List<Tour> tours = tp.leitaDaytour();
            ObservableList<Tour> obl = FXCollections.observableArrayList(tours);
            searchedDaytours.setItems(obl);
        } catch (Exception e) {
            errorArea.setText("Villa: " + e);
        }

    }

}
