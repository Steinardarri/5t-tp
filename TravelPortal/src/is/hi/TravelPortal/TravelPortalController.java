package is.hi.TravelPortal;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import java.net.URL;
import java.time.LocalDate;
import javafx.fxml.Initializable;

public class TravelPortalController implements Initializable {

    private TravelPortal tp;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tp = new TravelPortal();
    }

    @FXML
    private void leitaFlugHandler(ActionEvent event) {
        LocalDate dep = flightDep.getValue();
        LocalDate arr = flightArr.getValue();
        String from = flightFrom.getText();
        String to = flightTo.getText();


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


    }

}
