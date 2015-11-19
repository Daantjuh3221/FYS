/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Login;

import Fys.Tools.Password;
import Fys.Models.User;
import com.Main.MainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Daan
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label lblError;
    @FXML
    private void btnLoginAction(ActionEvent event) throws Exception{
        if (!txtUsername.getText().equals("") && !txtPassword.getText().equals("")) {
            User user = new User().getUserByUsername(txtUsername.getText());
            if(user.getId() != 0){
                if (Password.check(txtPassword.getText(), user.getPassword())) {
                   ((Node)event.getSource()).getScene().getWindow().hide();
                    showUserDialog(user);
                }
                else{
                    lblError.setText("Invalid login");
                }
            }
            else{
                lblError.setText("Invalid login");
            }
        }else{
            txtUsername.setStyle("-fx-text-box-border: red;");
            txtPassword.setStyle("-fx-text-box-border: red;");
            lblError.setText("Username and/or password is not filled");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    
    public Stage showUserDialog(User user) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/Main.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((Pane) loader.load()));
        MainController controller = loader.<MainController>getController();
        controller.currentUser(user);
        stage.setTitle("Main");
        stage.show();
        return stage;
    }
    
}
