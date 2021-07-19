package Service;

import Entity.User;

import java.sql.SQLException;

public interface UserMenuInterface {
    //TODO about throws and overloading
    void signUp() throws SQLException;
    void Login() throws SQLException;
    void chargeCreadit()throws SQLException;
    void chargeCreadit(String username)throws SQLException;
}
