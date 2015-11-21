package Fys.Controllers;

import Fys.Models.User;
import Fys.Views.ViewModels.AccountTabelView;
import Fys.Tools.Screen;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class. This class controls the Account Overview screen 
 * including it's features.
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class AccountOverviewController implements Initializable {
    
    private static User currentUser;
    
    @FXML private Label lblUsername;
    @FXML private TableView tblUsers;
    @FXML private TableColumn columnUsername;
    @FXML private TableColumn columnFirstname;
    @FXML private TableColumn columnLastname;
    @FXML private TableColumn columnRole;
    @FXML private TableColumn columnActive;
    @FXML private TextField lblSearch;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblUsername.setText(currentUser.getUsername());
        columnUsername.setCellValueFactory(new PropertyValueFactory<AccountTabelView, String>("username"));
        columnFirstname.setCellValueFactory(new PropertyValueFactory<AccountTabelView, String>("firstname"));
        columnLastname.setCellValueFactory(new PropertyValueFactory<AccountTabelView, String>("lastname"));
        columnRole.setCellValueFactory(new PropertyValueFactory<AccountTabelView, String>("role"));
        columnActive.setCellValueFactory(new PropertyValueFactory<AccountTabelView, String>("active"));
        try {
            tblUsers.setItems(getUserList());
        } catch (Exception ex) {
            Logger.getLogger(AccountOverviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void btnAddAccountEvent(ActionEvent event) throws Exception {
        Screen screen = new Screen();
        AccountAddController.getUser(currentUser);
        ((Node) event.getSource()).getScene().getWindow().hide();
        screen.change("AccountAdd", "Add Account");
    }
    
    @FXML
    private void btnSearchAccountEvent(ActionEvent event) throws Exception {
        System.out.println("Search Accounts");
        ObservableList<AccountTabelView> userList= new AccountTabelView().getAccountList(lblSearch.getText());
        
        tblUsers.setItems(userList);
    }
    
    @FXML
    private void btnLogoutEvent(ActionEvent event) {
        System.out.println("Log out");
    }
    
    public static void getUser(User user)   {
        currentUser = user;
    }
    
    public ObservableList<AccountTabelView> getUserList() throws Exception{
        ObservableList<AccountTabelView> userList= new AccountTabelView().getAccountList();
        return userList;
    }
}
