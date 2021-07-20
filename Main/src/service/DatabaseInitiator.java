package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseInitiator {


    public Connection getCreatedConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/publication",
                    "root",
                    "aminty2015");
            PrintMessage.printMsg("Connection created successfuly.");
            return connection;
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        return null;
    }


}
