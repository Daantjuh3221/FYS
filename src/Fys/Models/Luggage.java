package Fys.Models;

import Fys.Tools.ConnectMysqlServer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jeffrey van der Lingen, IS106-2
 */
public class Luggage {

    private int id;
    private String type;
    private String brand;
    private String material;
    private String color;
    private String comment;
    private int statusId;
    private Date registerDate;
    private Status status;

    public Luggage() {
        this.type = "";
        this.brand = "";
        this.material = "";
        this.color = "";
        this.comment = "";
        this.statusId = 0;
        this.registerDate = null;
        this.status = new Status();
    }

    public Luggage(String type, String brand, String material, String color, String comment, int statusId) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public int getLuggageStatusIdByName(String statusName) {
        switch (statusName) {
            case ("Lost"):
                return 1;
            case ("Found"):
                return 2;
            case ("Connected"):
                return 3;
            default:
                return 0;
        }
    }

    public void insertLuggage(Luggage luggage) throws ClassNotFoundException, SQLException {
        try (Connection db = new ConnectMysqlServer().dbConnect()) {
            String query = ("INSERT INTO luggage (type,brand,material,color,comment,registerdate,statusid) VALUES (?,?,?,?,?,?,?)");
            PreparedStatement preparedStatement = (PreparedStatement) db.prepareStatement(query);
            preparedStatement.setString(1, luggage.type);
            preparedStatement.setString(2, luggage.brand);
            preparedStatement.setString(3, luggage.material);
            preparedStatement.setString(4, luggage.color);
            preparedStatement.setString(5, luggage.comment);
            preparedStatement.setDate(6, luggage.registerDate);
            preparedStatement.setInt(7, luggage.statusId);
            preparedStatement.executeUpdate();
        }
    }

//    public User getUserById(int id) throws ClassNotFoundException, SQLException {
//        try (Connection db = new ConnectMysqlServer().dbConnect()) {
//            Statement statement = db.createStatement();
//            ResultSet result = statement.executeQuery("select * from users where id=" + id);
//            while (result.next()) {
//                this.id = result.getInt(1);
//                this.username = result.getString(2);
//                this.password = result.getString(3);
//                this.firstname = result.getString(4);
//                this.lastname = result.getString(5);
//                this.roleId = result.getInt(6);
//                this.registerDate = result.getDate(7);
//                this.active = result.getBoolean(8);
//
//                this.role = new Role().getRoleById(this.roleId);
//            }
//        }
//        return this;
//    }
//
//    public User getUserByUsername(String username) throws ClassNotFoundException, SQLException {
//        try (Connection db = new ConnectMysqlServer().dbConnect()) {
//            Statement statement = db.createStatement();
//            ResultSet result = statement.executeQuery("select * from users where username='" + username + "'");
//            while (result.next()) {
//                this.id = result.getInt(1);
//                this.username = result.getString(2);
//                this.password = result.getString(3);
//                this.firstname = result.getString(4);
//                this.lastname = result.getString(5);
//                this.roleId = result.getInt(6);
//                this.registerDate = result.getDate(7);
//                this.active = result.getBoolean(8);
//                this.role = new Role().getRoleById(this.roleId);
//            }
//        }
//        return this;
//    }
}
