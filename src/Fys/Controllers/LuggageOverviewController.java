package Fys.Controllers;

import Fys.Models.User;
import Fys.Tools.Screen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class. This class controls the Luggage Overview screen 
 * including it's features.
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class LuggageOverviewController implements Initializable {
    
    private static User currentUser;
    
    @FXML private Label lblUsername;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(currentUser.getUsername());
    }
    
    @FXML
    private void btnCustomerEvent(ActionEvent event) throws Exception {
        Screen screen = new Screen();
        AccountAddController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("CustomerOverview", "Customer Overview");
    }
    
    @FXML
    private void btnAddLuggageEvent(ActionEvent event) throws Exception {
        Screen screen = new Screen();
        AccountAddController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("LuggageAdd", "Add Luggage");
    }
    
    @FXML
    private void btnSearchLuggageEvent(ActionEvent event) {
        System.out.println("Search Customer");
    }
    
    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }  
    
    public static void getUser(User user)   {
        currentUser = user;
    }
    
}
