package Repository;

import Service.ApplicationObject;
import Service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepo {

    public void createCategoryTable() throws SQLException {
        Statement statement = ApplicationObject.getConnection().createStatement();
        statement.executeUpdate(
                "CREATE table IF not EXISTS category (id int AUTO_INCREMENT not null primary key," +
                        "categoryName varchar(20) unique )"
        );
        statement.close();
        initialCategory();
    }
    private void initialCategory() throws SQLException {
        Statement statement = ApplicationObject.getConnection().createStatement();
        // ResultSet rs=statement.executeQuery("select count(categoryName) from category");
        ResultSet rs = statement.executeQuery("select categoryName from category");
        if (!rs.next()) {
            PreparedStatement prstm = ApplicationObject.getConnection().prepareStatement(
                    "insert into category(categoryName) values (?)");
            prstm.setString(1, "Unspecified");
            prstm.executeUpdate();
            prstm.setString(1, "Political");
            prstm.executeUpdate();
            prstm.setString(1, "Medical");
            prstm.executeUpdate();
            prstm.setString(1, "Romance");
            prstm.executeUpdate();
            prstm.setString(1, "Sport");
            prstm.executeUpdate();
        }
    }
    public boolean isCategoryExist(int id) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select id from category where id=?"
                );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public void getCategoryTable() throws SQLException {
        Statement stm = ApplicationObject.getConnection().createStatement();
        ResultSet rs = stm.executeQuery("select * from category");
        if (rs.next()) {
            do {
                System.out.print("[ " + rs.getString("id") + " - "+rs.getString("categoryName")+" ]  ");
            } while (rs.next());
        } else
            System.out.println("Category table is empty !");

        System.out.println();
        stm.close();
    }
    public boolean isCategoryExist(String categoryName) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select categoryName from category where categoryName=?"
                );
        ps.setString(1, categoryName);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public void addNewCategory(String categoryName) throws SQLException {

            PreparedStatement ps =
                    ApplicationObject.getConnection().prepareStatement(
                            "insert into category (categoryName) values (?)"
                    );
            ps.setString(1, categoryName);
            PrintMessage.printMsg("Category (" + categoryName + ") added successfuly");
            ps.executeUpdate();
            ps.close();

    }
}
