package Entity;

import java.sql.Timestamp;
import java.util.Arrays;

public class Article {

    private User user;
    private String brief;
    private String content;
    private Category category;
    private Timestamp createdDate;
    private Timestamp lastUpdateDate;
    private Timestamp publishedDate;
    private boolean isPublished;
    private Tag[] tags;

    public Article() {
    }

    public Article(User user, String brief, String content, Category category,
                   Timestamp createdDate, Timestamp lastUpdateDate, Timestamp publishedDate,
                   boolean isPublished, Tag[] tags) {
        this.user = user;
        this.brief = brief;
        this.content = content;
        this.category = category;
        this.createdDate = createdDate;
        this.lastUpdateDate = lastUpdateDate;
        this.publishedDate = publishedDate;
        this.isPublished = isPublished;
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "user=" + user +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", createdDate=" + createdDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", publishedDate=" + publishedDate +
                ", isPublished=" + isPublished +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
