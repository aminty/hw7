import service.ApplicationObject;

import java.sql.SQLException;

public class MainApplication {
    public static void main(String[] args) throws SQLException {
        ApplicationObject.tableCreator();
        ApplicationObject.getMenu().runPublicMenu();

    }

}
