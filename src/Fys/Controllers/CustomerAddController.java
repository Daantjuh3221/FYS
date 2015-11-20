package Fys.Controllers;

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
import javafx.stage.Stage;

/**
 * Event Handling Class. This class maintains all of the eventhandling in the
 * application.
 * @author IS106-2 'IT in Black II'
 */
public class CustomerAddController implements Initializable {
    
    @FXML
    private void btnLuggageEvent(ActionEvent event) throws Exception {
        changeScreen("FXMLLuggageOverview.fxml", "Luggage Overview", event);
    }
    
    @FXML
    private void btnCustomerEvent(ActionEvent event) throws Exception {
        changeScreen("FXMLCustomerOverview.fxml", "Luggage Overview", event);
    }
    
    @FXML
    private void btnAddCustomerEvent(ActionEvent event) {
        System.out.println("Customer Added");
    }
    
    @FXML
    private void btnBackToOverviewEvent(ActionEvent event) throws Exception {
        changeScreen("FXMLCustomerOverview.fxml", "Luggage Overview", event);
    }
    
    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void changeScreen(String FXMLfile, String setTitle, ActionEvent event) throws Exception{
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource(FXMLfile));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/Content/Css/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle(setTitle);
        stage.show();
    }
}
