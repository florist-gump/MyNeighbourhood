package hci.glasgow.myneighbourhood;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import models.*;
import models.Post;

/**
 * Created by Flo on 08/03/16.
 */
public class MyApp extends Application {
    private static Application instance;
    private static SharedPreferences prefs = null;
    private static Context context;
    private static ArrayList<Post> favorites;

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = getSharedPreferences("hci.glasgow.myneighbourhood", MODE_PRIVATE);
        instance = this;
        MyApp.context = getApplicationContext();
        favorites = new ArrayList<models.Post>();
    }

    public static Context getContext() {
        if(instance != null) {
            return instance.getApplicationContext();
        } else {
            return context;
        }
    }
    public static void addToFavorites (models.Post post) {
        favorites.add(post);
    }
    public static ArrayList<models.Post> getFavorites() {
        return favorites;
    }

}