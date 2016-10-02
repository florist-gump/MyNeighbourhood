package models;

import java.io.Serializable;

/**
 * Created by Flo on 14/02/16.
 */
public class PostReplies implements Serializable  {
    private String text;
    private  People author;

    public PostReplies(String text) {
        this.text = text;
    }

    public PostReplies(String text, People author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public People getAuthor() {
        return author;
    }

    public void setAuthor(People author) {
        this.author = author;
    }
}
