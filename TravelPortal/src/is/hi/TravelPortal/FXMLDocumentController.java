
package is.hi.TravelPortal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLDocumentController implements Initializable {
    
   /** 
     * Nöfnin á dýrunum. Notum þau líka fyrir myndirnar.
     * Er final því við breytum ekki fylkinu dyrHeiti
     * Er private því við viljum ekki að aðrir klasar hafi beint aðgang að breytunni
     */
    private final String[]  dyrHeiti = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
    @FXML
    private ImageView dyramynd;
    @FXML
    private ComboBox<String> dyr;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Frumstilla gögnin fyrir ComboBox
        frumstillaGögn();
       
    }    
    
    /**
     * Frumstillir gögn fyrir ComboBoxið jDyr 
     */
    private void frumstillaGögn() {
        
        ObservableList<String> dyraNofn =
                FXCollections.observableArrayList (dyrHeiti);
        
        // tengjum gögnin við viðmótshlutinn þannig að gögnin birtist í notendaviðmótinu
        dyr.setItems(dyraNofn);
    }

    /**
     * Uppfærir mynd á dyramynd
     * @param name nafn á dýrinu 
     */
    private void uppfæraMynd(String name) {
        ImageView icon = buaTilMynd("myndir/" + name + ".gif");
        dyramynd.setImage(icon.getImage());
    }
    
    /**
     * Býr til Mynd 
     * @param path slóðin með myndunum
     * @return skilar myndinni en null ef skráin fannst ekki 
     * 
     * Þetta er dæmi um aðferð sem má vera static því hún meðhöndlar
     * ekki tilviksbreytur. 
     */
    
     private static ImageView buaTilMynd(String path) {
        java.net.URL imgURL = FXMLDocumentController.class.getResource(path);
        if (imgURL != null) {
            return new ImageView(new Image(imgURL.toString()));
        } else {
            System.err.println("Fann ekki skrána " + path);
            return null;
        }
    }
    /**
     * Atburðarhandler fyrir val á dyr
     * @param evt upplýsingar um atburðinn, m.a. viðmótshluturinn sem bjó til atburðinn 
     */
    @FXML
    private void jDyrActionPerformed(ActionEvent evt) {                                     
        // Frá hvaða hlut kom atburðurinn 
        ComboBox cb = (ComboBox)evt.getSource();
        
        // Hvaða dýr er valið 
        // Sjáum að það er hægt að biðja ComboBoxið um að skila stakinu 
        String dyraNafn = (String)cb.getSelectionModel().getSelectedItem();   
     
        // Uppfærum mynd með nýju dýri 
        uppfæraMynd(dyraNafn);
    }                                    

}
