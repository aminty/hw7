package Repository;

import Entity.Article;
import Service.ApplicationObject;
import Service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticleRepo {
    public void createArticleTable() throws SQLException    {
        Statement stm = ApplicationObject.getConnection().createStatement();
        stm.executeUpdate("CREATE table IF not EXISTS article (id int AUTO_INCREMENT not null primary key," +
                "user_id int ," +
                "title varchar(20) unique ," +
                "brief varchar(100)," +
                "content TEXT," +
                "createDate timestamp ," +
                "lastUpdate timestamp ," +
                "publishDate timestamp ," +
                "isPublished boolean default 0," +
                "category_id int," +
                "price int default 0," +
                "isFree boolean default 0," +
                "foreign key (user_id) references user(id) ON DELETE CASCADE," +
                "foreign key (category_id) references category(id) ON DELETE CASCADE)");

        stm.close();
    }
    public boolean isTitleExist(String title) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select title from article where title=?"
                );
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public void addNewArticle(Article article) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "insert into " +
                        "article(user_id,title,brief,content,createDate,lastUpdate,publishDate,isPublished,category_id,price,isFree)" +
                        "values (?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, article.getUserId());
        ps.setString(2, article.getTitle());
        ps.setString(3, article.getBrief());
        ps.setString(4, article.getContent());
        ps.setTimestamp(5, article.getCreatedDate());
        ps.setTimestamp(6, article.getLastUpdateDate());
        ps.setTimestamp(7, article.getPublishedDate());
        ps.setBoolean(8, article.getIsPublished());
        ps.setInt(9, article.getCategory_id());
        ps.setInt(10, article.getPrice());
        ps.setBoolean(11, article.getIsFree());

        if (ps.executeUpdate() == 1)
            PrintMessage.printMsg("Your article wrote successfuly");
        ps.close();


    }

    public int getId(String title) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select id from article where title=?"
                );
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        int id=1;
       while (rs.next()){
           return rs.getInt("id");

       }
       return id;

    }

}
