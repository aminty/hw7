package Repository;

import Entity.User;
import Service.ApplicationObject;
import Service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo implements BaseRepo {

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
                "creadit int default  0 ," +
                "isAdmin boolean default 0," +
                "isApprove boolean default 0)");
        stm.close();
    }

    public User getUserInfo(String username) throws SQLException {
        User user = new User();
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "SELECT * from user where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user.setFirstName(rs.getString("name"));
            user.setLastName(rs.getString("lastName"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setBirthday(String.valueOf(rs.getString("birthday")));
            user.setNationalCode(rs.getString("nationalCode"));
            user.setId(rs.getInt("id"));
            user.setCreadit(rs.getInt("creadit"));
            user.setAdmin(rs.getBoolean("isAdmin"));
            user.setApprove(rs.getBoolean("isApprove"));
        }
        return user;

    }

    @Override
    public void findAll() {

    }

    @Override
    public void delete(int id) {

    }

    public void updateCreadit(String username, int price, int currentBalance) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "update user  set creadit=?  where username = ?");
        ps.setInt(1, price + currentBalance);
        ps.setString(2, username);
        ps.executeUpdate();
        PrintMessage.printMsg(price + " Tomans was deposited in your account");
    }

    public int getCreadit(String username) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "select creadit from user where username = ?");
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt("creadit");
        }
        return 0;
    }
}
