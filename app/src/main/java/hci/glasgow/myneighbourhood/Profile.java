package hci.glasgow.myneighbourhood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import Controller.Replies;
import models.People;
import models.PostReplies;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final models.People profile = (models.People) getIntent().getSerializableExtra("Profile");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(profile.getFirstName());
        actionBar.setDisplayHomeAsUpEnabled(true);


        TextView firstName = (TextView)findViewById(R.id.profile_first_name);
        firstName.setText(profile.getFirstName());
        TextView lastName = (TextView)findViewById(R.id.profile_last_name);
        lastName.setText(profile.getLastName());

        Button chat = (Button)findViewById(R.id.send_message);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Profile.this, InsideChatActivity.class);
                Profile.this.startActivity(myIntent);
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
