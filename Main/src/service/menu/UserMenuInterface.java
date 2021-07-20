package service.menu;

import java.sql.SQLException;

public interface UserMenuInterface {
    //TODO about throws and overloading is it true?
    void signUp() throws SQLException;
    void Login() throws SQLException;
    void chargeCreadit()throws SQLException;
    void chargeCreadit(String username)throws SQLException;
    void changeUsername(int id)throws SQLException;
    void changePassword(int id)throws SQLException;
    void removeAccount(int id)throws SQLException;


}
