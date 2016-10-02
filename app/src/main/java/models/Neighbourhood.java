package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flo on 14/02/16.
 */
public class Neighbourhood implements Serializable {
    private boolean verified;
    private String name;
    private ArrayList<People> members;
    private ArrayList<Post> posts;

    public Neighbourhood(String name) {
        this.name = name;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<People> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<People> members) {
        this.members = members;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
