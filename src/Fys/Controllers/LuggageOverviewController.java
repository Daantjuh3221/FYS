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
public class LuggageOverviewController implements Initializable {
    
    @FXML
    private void btnLuggageEvent(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLLuggageOverview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Luggage Overview");
        stage.show();
    }
    
    @FXML
    private void btnCustomerEvent(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLCustomerOverview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Customer Overview");
        stage.show();
    }
    
    @FXML
    private void btnAddLuggageEvent(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLLuggageAdd.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.show();
    }
    
    @FXML
    private void btnSearchLuggageEvent(ActionEvent event) {
        System.out.println("Search Customer");
    }
    
    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
