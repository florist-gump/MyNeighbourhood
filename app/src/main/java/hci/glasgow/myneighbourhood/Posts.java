package hci.glasgow.myneighbourhood;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Controller.NeighbourhoodAdapter;
import Controller.PostsAdapter;
import Helpers.DataGenerator;
import models.Neighbourhood;
import models.Post;

public class Posts extends AppCompatActivity {

    private Neighbourhood neighbourhood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        ListView listView = (ListView) findViewById(R.id.posts_list);

        Neighbourhood neighbourhood = (Neighbourhood) getIntent().getSerializableExtra("Neighbourhood");
        this.neighbourhood = neighbourhood;

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(neighbourhood.getName());
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<Post> posts = neighbourhood.getPosts();
        PostsAdapter adapter = new PostsAdapter(this,posts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                models.Post post = (models.Post) parent.getAdapter().getItem(position);
                Intent myIntent = new Intent(Posts.this, hci.glasgow.myneighbourhood.Post.class);
                myIntent.putExtra("Post", post);
                Posts.this.startActivity(myIntent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_post);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Posts.this, "Adding additional posts is not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_info:
                Intent myIntent = new Intent(Posts.this, hci.glasgow.myneighbourhood.NeighbourhoodInfo.class);
                myIntent.putExtra("Neighbourhood",neighbourhood);
                Posts.this.startActivity(myIntent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_neighbourhood, menu);
        return true;
    }
}
