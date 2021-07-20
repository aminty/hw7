package Entity;

import java.sql.Timestamp;

public class Article {

    private int userId;
    private String title;
    private String content;
    private int category_id;
    private String brief;
    private int id;

    private boolean isPublished;
    private Timestamp createdDate;
    private Timestamp lastUpdateDate;
    private Timestamp publishedDate;
    private boolean isFree;
    private int price;
    private int[] tags_id;

    public Article() {
    }

    public Article(int userId, String title, String content,
                   int category_id, String brief, boolean isPublished,
                   Timestamp createdDate, Timestamp lastUpdateDate,
                   Timestamp publishedDate, boolean isFree, int price, int[] tag_id) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.brief = brief;

        this.isPublished = isPublished;
        this.createdDate = createdDate;
        this.lastUpdateDate = lastUpdateDate;
        this.publishedDate = publishedDate;
        this.isFree = isFree;
        this.price = price;
        this.tags_id = tags_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Timestamp getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Timestamp publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean free) {
        isFree = free;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int[] getTags() {
        return tags_id;
    }

    public void setTags(int[] tag_id) {
        this.tags_id = tag_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article -->" +
                " id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", isPublished=" + isPublished +
                ", isFree=" + isFree +
                ", price=" + price +
                "";
    }
}
