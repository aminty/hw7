package Service;

import java.sql.Connection;

public class ApplicationObject {

     private static Connection connection=new DatabaseInitiator().getCreatedConnection();
     public static Connection getConnection(){
         return connection;
     }

     private static Menu menu =new Menu();
     public static Menu getMenu(){
         return menu;
     }

     private static Validation validation=new Validation();
     public static Validation getValidation(){
         return validation;
     }


}
