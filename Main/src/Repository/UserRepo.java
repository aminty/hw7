package Repository;

import Entity.User;
import Service.ApplicationObject;
import Service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo implements BaseRepo{


    public boolean isUsernameExist(String username) throws SQLException {

        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "SELECT username from user where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();

        return rs.next();
    }
    public boolean isNatioalCodeExist(String nationalCode) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "SELECT nationalCode from user where nationalCode = ?");
        ps.setString(1, nationalCode);
        ResultSet resultSet = ps.executeQuery();
        return resultSet.next();

    }
    public void addNewUser(User users) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "insert into user " +
                                "(name," +
                                "lastName," +
                                "username," +
                                "password," +
                                "birthday," +
                                "nationalCode," +
                                "creadit)" +
                                "values (?,?,?,?,?,?,?)");
        ps.setString(1, users.getFirstName());
        ps.setString(2, users.getLastName());
        ps.setString(3, users.getUsername());
        ps.setString(4, users.getPassword());
        ps.setDate(5, java.sql.Date.valueOf(users.getBirthday()));
        ps.setString(6, users.getNationalCode());
        ps.setInt(7, users.getCreadit());
        if (ps.executeUpdate() == 1)
            PrintMessage.printMsg("Your account created successfuly");
        ps.close();


    }
    public void createUserTable() throws SQLException {
        Statement stm = ApplicationObject.getConnection().createStatement();
        stm.executeUpdate("CREATE table IF not EXISTS user (id int AUTO_INCREMENT not null primary key," +
                "name varchar(20)," +
                "lastName varchar(20)," +
                "username varchar(30) unique ," +
                "password varchar (16)," +
                "birthday DATE ," +
                "nationalCode varchar(10) unique ," +
                "creadit int default  0)");
        stm.close();
    }
    public ResultSet getUserInfo(String username) throws SQLException {

        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "SELECT * from user where username = ?");
        ps.setString(1, username);
        return ps.executeQuery();
    }

    @Override
    public void findAll() {

    }

    @Override
    public void delete(int id) {

    }


}
