package Fys.Controllers;

import Fys.Models.User;
import Fys.Tools.Screen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class. This class controls the Main screen including it's
 * features.
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class MainController implements Initializable {

    private static User currentUser;
    
    private Screen screen = new Screen();
    
    @FXML private Label lblUsername;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(currentUser.getUsername());
    }
    
    @FXML
    private void btnLuggageEvent(ActionEvent event) throws Exception {
        LuggageOverviewController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("LuggageOverview", "Luggage Overview");
    }

    @FXML
    private void btnCustomerEvent(ActionEvent event) throws Exception {
        CustomerOverviewController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();        
        screen.change("CustomerOverview", "Customer Overview");
    }

    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }
    
    public static void getUser(User user){
        currentUser = user;
    }

}
