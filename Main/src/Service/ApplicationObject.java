package Service;

import java.sql.Connection;

public class ApplicationObject {

     private static Connection connection=new DatabaseInitiator().getCreatedConnection();
     public static Connection getConnection(){
         return connection;
     }


}
