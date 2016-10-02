package hci.glasgow.myneighbourhood;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CreateNeighbourhood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_neighbourhood);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("create new neighbourhood");
        actionBar.setDisplayHomeAsUpEnabled(true);

        RelativeLayout root = (RelativeLayout) findViewById(R.id.mainlayoutcreate);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateNeighbourhood.this, "Creating a neighbourhood is not yet implemented", Toast.LENGTH_SHORT).show();
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
