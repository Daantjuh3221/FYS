/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fys.Views.ViewModels;

import Fys.Models.Role;
import Fys.Models.User;
import Fys.Tools.ConnectMysqlServer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daan
 */
public class AccountTabelView {
    private String username;
    private String firstname;
    private String lastname;
    private String role;
    private String active;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    
    
    
    public ObservableList<AccountTabelView> getAccountList() throws Exception{
        ObservableList<AccountTabelView> users= FXCollections.observableArrayList();
        try (Connection db = new ConnectMysqlServer().dbConnect()) {
            Statement statement = db.createStatement();
            ResultSet result;
            result = statement.executeQuery("select * from users");
            while (result.next()) {
                AccountTabelView foundUsers = new AccountTabelView();
                Role role = new Role().getRoleById(result.getInt(6));
                foundUsers.setUsername(result.getString(2));
                foundUsers.setFirstname(result.getString(4));
                foundUsers.setLastname(result.getString(5));
                foundUsers.setRole(role.getRoleName());
                if (result.getBoolean(8)) {
                    foundUsers.setActive("Active");
                }
                else{
                    foundUsers.setActive("In active");
                }
                users.add(foundUsers);
            }
        }
        return users;
    }
    public ObservableList<AccountTabelView> getAccountList(String searchTerm) throws Exception{
        ObservableList<AccountTabelView> users= FXCollections.observableArrayList();
        try (Connection db = new ConnectMysqlServer().dbConnect()) {
            Statement statement = db.createStatement();
            ResultSet result;
            result = statement.executeQuery("select * from users where username='" + searchTerm + "' or firstname='" + searchTerm + "' or lastname='" + searchTerm + "'");
            while (result.next()) {
                AccountTabelView foundUsers = new AccountTabelView();
                Role role = new Role().getRoleById(result.getInt(6));
                foundUsers.setUsername(result.getString(2));
                foundUsers.setFirstname(result.getString(4));
                foundUsers.setLastname(result.getString(5));
                foundUsers.setRole(role.getRoleName());
                if (result.getBoolean(8)) {
                    foundUsers.setActive("Active");
                }
                else{
                    foundUsers.setActive("In active");
                }
                users.add(foundUsers);
            }
        }
        return users;
    }
}
