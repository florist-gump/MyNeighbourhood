package hci.glasgow.myneighbourhood;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import Controller.Replies;
import Helpers.MLRoundedImageView;
import models.People;
import models.PostReplies;

public class Post extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final models.Post post = (models.Post) getIntent().getSerializableExtra("Post");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(post.getDescription());
        actionBar.setDisplayHomeAsUpEnabled(true);


        TextView firstName = (TextView)findViewById(R.id.post_first_name);
        firstName.setText(post.getAuthor().getFirstName());
        TextView lastName = (TextView)findViewById(R.id.post_last_name);
        lastName.setText(post.getAuthor().getLastName());

        TextView text = (TextView)findViewById(R.id.post_text);
        if(!post.getText().isEmpty()) {
            text.setText(post.getText());
        } else {
            text.setText(post.getDescription());
        }


        ListView listView = (ListView) findViewById(R.id.replies_list);
        final Replies adapter = new Replies(this,post.getReplies());
        listView.setAdapter(adapter);

        final EditText edit = (EditText) findViewById(R.id.reply_edittext);

        edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //only send text when send button on the right is clicked
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (edit.getRight() - edit.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // post with dummy person, should get the currently logged in user
                        PostReplies reply = new PostReplies(edit.getText().toString(), new People("Michael", "1"));
                        post.addReply(reply);
                        adapter.notifyDataSetChanged();
                        edit.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        View view = (View) findViewById(R.id.post_profile);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Post.this, hci.glasgow.myneighbourhood.Profile.class);
                myIntent.putExtra("Profile", post.getAuthor());
                Post.this.startActivity(myIntent);
            }
        });

        ImageView fav_icon = (ImageView) findViewById(R.id.fav_icon);
        fav_icon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ImageView fav_icon = (ImageView) findViewById(R.id.fav_icon);
                fav_icon.setImageResource(R.drawable.fav);
                MyApp.addToFavorites(post);
                Toast.makeText(Post.this, "Post was added to your favorites", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
