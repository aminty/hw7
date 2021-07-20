package Repository;

import Entity.Article;
import Service.ApplicationObject;
import Service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ArticleRepo {
    public void createArticleTable() throws SQLException {
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
    public boolean isTitleExist(int id) throws SQLException {
        PreparedStatement ps =
                ApplicationObject.getConnection().prepareStatement(
                        "select id from article where id=?"
                );
        ps.setInt(1, id);
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
        int id = 1;
        while (rs.next()) {
            return rs.getInt("id");

        }
        return id;

    }

    public void getArticleInfo(int id) throws SQLException {
        Article article = new Article();
        PreparedStatement pr = ApplicationObject.getConnection().prepareStatement(
                "SELECT * from article where user_id=?"
        );
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            article.setId(rs.getInt("id"));
            article.setTitle(rs.getString("title"));
            article.setUserId(rs.getInt("user_id"));
            article.setBrief(rs.getString("brief"));
            article.setContent(rs.getString("content"));
            article.setCategory_id(rs.getInt("category_id"));
            article.setIsFree(rs.getBoolean("isFree"));
            article.setPrice(rs.getInt("price"));
            article.setIsPublished(rs.getBoolean("isPublished"));
            article.setCreatedDate(rs.getTimestamp("createDate"));
            article.setPublishedDate(rs.getTimestamp("publishDate"));
            article.setLastUpdateDate(rs.getTimestamp("lastUpdate"));
            System.out.println(article.toString());

        }

    }

    public void getPrivateArticle() throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "select * from article where isPublished=false");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("[ " + rs.getInt("id") + " - " + rs.getString("title") + " ]");
        }
    }

    public void setPrivateArticle(int article_id) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "update article  set isPublished=?  where id = ?");
        ps.setBoolean(1, false);
        ps.setInt(2, article_id);
        ps.executeUpdate();
        PrintMessage.printMsg("Article made private successfuly .");
    }

    public void getPublicArticle() throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "select * from article where isPublished=true");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("[ " + rs.getInt("id") + " - " + rs.getString("title") + " ]");
        }
    }

    public void setPublicArticle(int article_id) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "update article  set isPublished=?  where id = ?");
        ps.setBoolean(1, true);
        ps.setInt(2, article_id);
        ps.executeUpdate();
        PrintMessage.printMsg("Article made public successfuly .");
    }


}
