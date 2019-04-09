package is.hi.TravelPortal2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Olgeir Ingi - oia4@hi.is
 * @author Steinar Darri - sth319@hi.is
 */
public class TravelPortalMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Travel Portal");
        Parent root = FXMLLoader.load(getClass().getResource("travelportal2.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
