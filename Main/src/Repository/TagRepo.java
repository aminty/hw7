package Repository;

import Service.ApplicationObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TagRepo {
    public void createTagTable() throws SQLException {
        Statement statement = ApplicationObject.getConnection().createStatement();
        statement.executeUpdate(
                "CREATE table IF not EXISTS tag (id int AUTO_INCREMENT not null primary key," +
                        "tagName varchar(20) unique )"
        );
        statement.close();
    }
    public void createTakenTag() throws SQLException {
        Statement statement=ApplicationObject.getConnection().createStatement();
        statement.executeUpdate("CREATE table IF not EXISTS takenTag (id int AUTO_INCREMENT not null primary key," +
                "user_id int ,article_id int,tag_id int," +
                "foreign key (user_id) references user(id) ON DELETE CASCADE," +
                "foreign key (article_id) references article(id) ON DELETE CASCADE," +
                "foreign key (tag_id) references tag(id) ON DELETE CASCADE)");
        statement.close();
    }
    public boolean isTagExist(String tagName) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select tagName from tag where tagName=?"
                );
        ps.setString(1, tagName);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

}
