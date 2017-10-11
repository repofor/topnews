package tech.topnews.blog.entities;

import java.util.Date;

public class Post {
    private Long id;
    private String title;
    private String body;
    private User user;

    public Post() {
    }

    public Post(Long id, String title, String body, User user) {

        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date = new Date();


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
