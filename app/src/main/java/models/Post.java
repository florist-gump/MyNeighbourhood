package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import Helpers.DataGenerator;

/**
 * Created by Flo on 14/02/16.
 */
public class Post implements Serializable {
    private String description;
    private String text;
    private Date createdAt;
    private People author;
    private ArrayList<PostReplies> replies;

    public ArrayList<PostReplies> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<PostReplies> replies) {
        this.replies = replies;
    }

    public Post(People author, String description) {
        this(author,description,"");
    }

    public Post(People author, String description, String text) {
        this.author = author;
        this.text = text;
        this.description = description;
        this.createdAt = new Date();
        replies = DataGenerator.generateReplies();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public People getAuthor() {
        return author;
    }

    public void setAuthor(People author) {
        this.author = author;
    }

    public void addReply(PostReplies reply) {
        replies.add(reply);
    }
}
