package repository;

import service.ApplicationObject;
import service.PrintMessage;

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
        Statement statement = ApplicationObject.getConnection().createStatement();
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

    public boolean isTagExist(int id) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select id from tag where id=?"
                );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void getTagTable() throws SQLException {
        Statement statement = ApplicationObject.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tag");
        if (resultSet.next()) {
            do {
                System.out.print("[ " + resultSet.getInt("id") + " - " + resultSet.getString("tagName") + " ]  ");
            } while (resultSet.next());
        } else
            PrintMessage.printMsg("Tag table is empty !");

        System.out.println();
        statement.close();
    }

    public void addNewTag(String tagName) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "insert into tag (tagName) values (?)"
                );
        ps.setString(1, tagName);
        ps.executeUpdate();
        ps.close();
    }

    public void takenTagByArticle(int user_id, int article_id, int tag_id) throws SQLException {
        PreparedStatement prs = ApplicationObject.getConnection().prepareStatement(
                "insert into takenTag(user_id,article_id,tag_id) values (?,?,?)"
        );
        prs.setInt(1, user_id);
        prs.setInt(2, article_id);
        prs.setInt(3, tag_id);
        prs.execute();


    }

}
