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
 * FXML Controller class. This class controls the Edit Account screen including it's
 * features.
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class AccountEditController implements Initializable {
    
    private static User currentUser;
    
    private Screen screen = new Screen();
    
    @FXML private Label lblUsername;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(currentUser.getUsername());
    }
    
    @FXML
    private void btnAccountEvent(ActionEvent event) throws Exception {
        AccountOverviewController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("AccountOverview", "Account Overview");
    }
    
    @FXML
    private void btnSaveChangesEvent(ActionEvent event) {
        System.out.println("Changes Saved");
    }
    
    @FXML
    private void btnBackToOverviewEvent(ActionEvent event) throws Exception {
        AccountOverviewController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("AccountOverview", "Account Overview");
    }
    
    @FXML
    private void boxDisableAccountEvent(ActionEvent event) {
        System.out.println("Box checked");
    }
    
    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }
    
    public static void getUser(User user){
        currentUser = user;
    }
}
