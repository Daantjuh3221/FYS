package Fys.Controllers;

import Fys.Models.User;
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
 * FXML Controller class. This class controls the Customer Edit screen including it's
 * features.
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class CustomerEditController implements Initializable {
    
    public static User currentUser;
    
    @FXML private Label lblUsername;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(currentUser.getUsername());
    }
    
    @FXML
    private void btnLuggageEvent(ActionEvent event) throws Exception {
        LuggageOverviewController.currentUser = currentUser;
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/Fys/Views/LuggageOverview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/Fys/Content/Css/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Luggage Overview");
        stage.show();
    }
    
    @FXML
    private void btnCustomerEvent(ActionEvent event) throws Exception {
        CustomerOverviewController.currentUser = currentUser;
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/Fys/Views/CustomerOverview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/Fys/Content/Css/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Customer Overview");
        stage.show();
    }
    
    @FXML
    private void btnSaveChangesEvent(ActionEvent event) throws IOException {
        System.out.println("Saved Changes");
    }
    
    @FXML
    private void btnBackToOverviewEvent(ActionEvent event) throws IOException {
        CustomerOverviewController.currentUser = currentUser;
        ((Node) event.getSource()).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("/Fys/Views/CustomerOverview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("/Fys/Content/Css/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Customer Overview");
        stage.show();
    }

    @FXML
    private void btnPrintProofEvent(ActionEvent event) {
        System.out.println("Print Proof of Registration");
    }
    
    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }
    
}
