package Entity;

import java.sql.Timestamp;

public class Article {

    private String username;
    private String title;
    private String content;
    private int category_id;
    private String brief;
    private String createDate;
    private String publishDate;
    private String lastUpdate;
    private String isPublished;
    private Timestamp createdDate;
    private Timestamp lastUpdateDate;
    private Timestamp publishedDate;
    private boolean isFree;
    private int price;
    private Tag[] tags;
    public Article() {
    }

    public Article(String username, String title, String content,
                   int category_id, String brief, String createDate,
                   String publishDate, String lastUpdate, String isPublished,
                   Timestamp createdDate, Timestamp lastUpdateDate,
                   Timestamp publishedDate, boolean isFree, int price, Tag[] tags) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.category_id = category_id;
        this.brief = brief;
        this.createDate = createDate;
        this.publishDate = publishDate;
        this.lastUpdate = lastUpdate;
        this.isPublished = isPublished;
        this.createdDate = createdDate;
        this.lastUpdateDate = lastUpdateDate;
        this.publishedDate = publishedDate;
        this.isFree = isFree;
        this.price = price;
        this.tags = tags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
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

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }
}
