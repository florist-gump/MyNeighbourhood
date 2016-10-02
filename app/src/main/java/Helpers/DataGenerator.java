package Helpers;

import java.util.ArrayList;
import java.util.List;

import models.Neighbourhood;
import models.People;
import models.Post;
import models.PostReplies;

/**
 * Created by Flo on 14/02/16.
 */
public abstract class DataGenerator {
    public static ArrayList<Neighbourhood> generateNeighbourhoods() {
        //generate some dummy data
        People p1 = new People("Peter", "Smith");
        People p2 = new People("Anna", "Hunter");
        ArrayList<People> people = new ArrayList<People>();
        people.add(p1); people.add(p2);

        Post post1 = new Post(p1,"Babysitter needed","Hi we need a Babysitter for next Friday. Please send me a private message if you are interested. Pay is 5 pound per hour");
        Post post2 = new Post(p1,"Car for sale");
        Post post3 = new Post(p2,"Looking for plumber");
        Post post4 = new Post(p2,"Free beer");

        ArrayList<Post> posts = new ArrayList<Post>();
        posts.add(post1);posts.add(post2);posts.add(post3);posts.add(post4);


        Neighbourhood n1 = new Neighbourhood("Partick");
        n1.setPosts(posts);
        n1.setMembers(people);
        Neighbourhood n2 = new Neighbourhood("West End");
        n2.setPosts(posts);
        n2.setMembers(people);
        ArrayList<Neighbourhood> neighbourhoods = new ArrayList<Neighbourhood>();
        neighbourhoods.add(n1);
        neighbourhoods.add(n2);
        return neighbourhoods;
    }

    public static ArrayList<PostReplies> generateReplies() {
        ArrayList<PostReplies> replies = new ArrayList<PostReplies>();
        People p1 = new People("Bob", "H");
        People p2 = new People("Emma", "Dough");
        PostReplies reply = new PostReplies("I'm interested");
        reply.setAuthor(p1);
        PostReplies reply2 = new PostReplies("Are you still looking?");
        reply2.setAuthor(p2);
        replies.add(reply);
        replies.add(reply2);
        return replies;
    }
}
