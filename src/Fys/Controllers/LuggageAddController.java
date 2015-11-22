package Fys.Controllers;

import Fys.Models.Luggage;
import Fys.Models.Status;
import Fys.Models.User;
import Fys.Tools.Screen;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class. This class controls the Add Luggage screen including
 * it's features.
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class LuggageAddController implements Initializable {
    
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
    private void ddwnLuggageFoundEvent(ActionEvent event) {
        ddwnLuggageStatus.setText("Found");
        ddwnLuggageStatus.setPrefWidth(200);
    }

    @FXML
    private void btnAddLuggageEvent(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (!(luggageType.getText().equals("")
                || luggageBrand.getText().equals("")
                || luggageMaterial.getText().equals("")
                || luggageColor.getText().equals(""))) {
            if (!ddwnLuggageStatus.getText().equals("Luggage Status")) {
                lblErrorMessage.setText("");
                luggageType.setStyle("-fx-border-width: 0px;");
                luggageBrand.setStyle("-fx-border-width: 0px;");
                luggageMaterial.setStyle("-fx-border-width: 0px;");
                luggageColor.setStyle("-fx-border-width: 0px;");
                
                Luggage luggage = new Luggage();
                luggage.setType(luggageType.getText());
                luggage.setBrand(luggageBrand.getText());
                luggage.setMaterial(luggageMaterial.getText());
                luggage.setColor(luggageColor.getText());
                luggage.setComment(luggageComments.getText());
                luggage.setStatusId(luggage.getLuggageStatusIdByName(ddwnLuggageStatus.getText()));
                luggage.setRegisterDate(null);
                //luggage.setStatus(new Status().getStatusByName(ddwnLuggageStatus.getText()));
                luggage.insertLuggage(luggage);
                
                System.out.println("Successfully added Luggage:");
                System.out.println("\t Type: " + luggageType.getText());
                System.out.println("\t Brand: " + luggageBrand.getText());
                System.out.println("\t Material: " + luggageMaterial.getText());
                System.out.println("\t Color: " + luggageColor.getText());
                System.out.println("\t Status: " + ddwnLuggageStatus.getText());
                System.out.println("\t Comments: " + luggageComments.getText());
            } else {
                lblErrorMessage.setText("Select a Luggage Status");
            }
        } else {
            lblErrorMessage.setText("One or more fields have not been filled out.");
            luggageType.setStyle("-fx-text-box-border: red;");
            luggageBrand.setStyle("-fx-text-box-border: red;");
            luggageMaterial.setStyle("-fx-text-box-border: red;");
            luggageColor.setStyle("-fx-text-box-border: red;");
        }
    }

    @FXML
    private void btnBackToOverviewEvent(ActionEvent event) throws Exception {
        LuggageOverviewController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("LuggageOverview", "Luggage Overview");
    }

    //-- DO NOT TOUCH THESE BUTTONS BELOW, THEY ARE THE DEFAULT MENU ITEMS --
    @FXML
    private void btnLuggageEvent(ActionEvent event) throws IOException {
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
    private void btnCustomerEvent(ActionEvent event) throws IOException {
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
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }   
    
    public static void getUser(User user){
        currentUser = user;
    }
}
