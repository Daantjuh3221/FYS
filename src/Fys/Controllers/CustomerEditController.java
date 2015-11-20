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
public class CustomerEditController implements Initializable {
    
    @FXML
    private void btnLuggageEvent(ActionEvent event) throws Exception {
        changeScreen("FXMLLuggageOverview.fxml", "Luggage Overview", event);
    }
    
    @FXML
    private void btnCustomerEvent(ActionEvent event) throws Exception {
        changeScreen("FXMLCustomerOverview.fxml", "Customer Overview", event);
    }
    
    @FXML
    private void btnSaveChangesEvent(ActionEvent event) throws IOException {
        System.out.println("Saved Changes");
    }
    
    @FXML
    private void btnBackToOverviewEvent(ActionEvent event) throws IOException {
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("FXMLCustomerOverview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.show();
    }

    @FXML
    private void btnPrintProofEvent(ActionEvent event) {
        System.out.println("Print Proof of Registration");
    }
    
    @FXML
    private void btnSearchCustomerEvent(ActionEvent event) {
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
