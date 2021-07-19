package Repository;

import Entity.Article;
import Service.ApplicationObject;
import Service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArticleRepo {
    public void createArticleTable() throws SQLException {
        Statement stm = ApplicationObject.getConnection().createStatement();
        stm.executeUpdate("CREATE table IF not EXISTS article (id int AUTO_INCREMENT not null primary key," +
                "user_id int ," +
                "title varchar(20) unique ," +
                "brief varchar(100)," +
                "content TEXT," +
                "createDate Date," +
                "lastUpdate Date," +
                "publishDate varchar(20) ," +
                "isPublished varchar (5)," +
                "category_id int," +
                "price int ," +
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
                        "article(username,title,brief,content,createDate,lastUpdate,publishDate,isPublished,category,price,isFree)" +
                        "values (?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, article.getUsername());
        ps.setString(2, article.getTitle());
        ps.setString(3, article.getBrief());
        ps.setString(4, article.getContent());
        ps.setDate(5, java.sql.Date.valueOf(article.getCreateDate()));
        ps.setDate(6, java.sql.Date.valueOf(article.getLastUpdate()));
        ps.setString(7, article.getPublishDate());
        ps.setString(8, article.getIsPublished());
        ps.setInt(9, article.getCategory_id());
        ps.setInt(10, article.getPrice());
        ps.setBoolean(11, article.getIsFree());

        if (ps.executeUpdate() == 1)
            PrintMessage.printMsg("Your article wrote successfuly");
        ps.close();


    }
}
