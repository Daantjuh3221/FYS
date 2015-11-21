/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fys.Tools;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Daan
 */
public class Screen {
    public Stage change(String viewName, String stageTitle) throws Exception {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fys/Views/"+viewName+".fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene((Pane) loader.load()));
                stage.getScene().getStylesheets().add("/Fys/Content/Css/stylesheet.css");
                stage.setTitle(stageTitle);
                
                stage.show();
                
                return stage;
    }
}
