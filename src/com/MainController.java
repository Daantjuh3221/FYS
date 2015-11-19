/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Daan
 */
public class MainController implements Initializable {

    private User user;
    
    @FXML
    private Label lblId;
    @FXML
    private Label lblUsername;
    @FXML
    private Label lblTest;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void currentUser(User user) throws Exception{
        this.user = user;
        
        lblId.setText("" + user.getId());
        lblUsername.setText(user.getUsername());
    }
    
}
