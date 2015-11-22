package Fys.Models;

import Fys.Tools.ConnectMysqlServer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daan
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int roleId;
    private Date registerDate;
    private boolean active;

    private Role role;

    public User() {
        this.username = "";
        this.password = "";
        this.firstname = "";
        this.lastname = "";
        this.roleId = 0;
        this.registerDate = null;
        this.active = true;
        this.role = new Role();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return this.role;
    }

    public void insertUser(User user) throws ClassNotFoundException, SQLException {
        try (Connection db = new ConnectMysqlServer().dbConnect()) {
            String query = ("INSERT INTO users (username,password,firstname,lastname,roleid,registerdate,active) VALUES (?,?,?,?,?,?,?,?)");
            PreparedStatement preparedStatement = (PreparedStatement) db.prepareStatement(query);
            preparedStatement.setString(1, user.username);
            preparedStatement.setString(2, user.password);
            preparedStatement.setString(3, user.firstname);
            preparedStatement.setString(4, user.lastname);
            preparedStatement.setInt(5, user.roleId);
            preparedStatement.setDate(6, user.registerDate);
            preparedStatement.setBoolean(7, user.active);
            preparedStatement.executeUpdate();
        }
    }
    
    
    

    public User getUserById(int id) throws ClassNotFoundException, SQLException {
        try (Connection db = new ConnectMysqlServer().dbConnect()) {
            Statement statement = db.createStatement();
            ResultSet result = statement.executeQuery("select * from users where id=" + id);
            while (result.next()) {
                this.id = result.getInt(1);
                this.username = result.getString(2);
                this.password = result.getString(3);
                this.firstname = result.getString(4);
                this.lastname = result.getString(5);
                this.roleId = result.getInt(6);
                this.registerDate = result.getDate(7);
                this.active = result.getBoolean(8);

                this.role = new Role().getRoleById(this.roleId);
            }
        }
        return this;
    }

    public User getUserByUsername(String username) throws ClassNotFoundException, SQLException {
        try (Connection db = new ConnectMysqlServer().dbConnect()) {
            Statement statement = db.createStatement();
            ResultSet result = statement.executeQuery("select * from users where username='" + username + "'");
            while (result.next()) {
                this.id = result.getInt(1);
                this.username = result.getString(2);
                this.password = result.getString(3);
                this.firstname = result.getString(4);
                this.lastname = result.getString(5);
                this.roleId = result.getInt(6);
                this.registerDate = result.getDate(7);
                this.active = result.getBoolean(8);
                this.role = new Role().getRoleById(this.roleId);
            }
        }
        return this;
    }
}
