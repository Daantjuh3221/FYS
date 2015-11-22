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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
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
    @FXML private Label lblErrorMessage;
    @FXML private MenuButton ddwnLuggageType;
    @FXML private TextField fieldLuggageSearchBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(currentUser.getUsername());
    }

    @FXML
    private void ddwnLuggageLostEvent(ActionEvent event) {
        ddwnLuggageType.setText("Lost");
        ddwnLuggageType.setPrefWidth(110);
    }

    @FXML
    private void ddwnLuggageFoundEvent(ActionEvent event) {
        ddwnLuggageType.setText("Found");
        ddwnLuggageType.setPrefWidth(110);
    }

    @FXML
    private void ddwnLuggageConnectedEvent(ActionEvent event) {
        ddwnLuggageType.setText("Connected");
        ddwnLuggageType.setPrefWidth(110);
    }

    @FXML
    private void btnSearchLuggageEvent(ActionEvent event) {
        if (!fieldLuggageSearchBox.getText().equals("")) {
            if (!ddwnLuggageType.getText().equals("Luggage Type")) {
                lblErrorMessage.setText("");
                //MYSQL SEARCH QUERY IN HERE
                //LOAD TABLE METHODS IN HERE
                System.out.println("Search Luggage type " + ddwnLuggageType.getText()
                        + " with query: " + fieldLuggageSearchBox.getText());
            } else {
                lblErrorMessage.setText("Select a luggage type");
            }
        } else {
            lblErrorMessage.setText("Search term cannot be empty");
        }
    }

    //-- DO NOT TOUCH THESE BUTTONS BELOW, THEY ARE THE DEFAULT MENU ITEMS --
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
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }  
    
    public static void getUser(User user)   {
        currentUser = user;
    }
    
}
