package hci.glasgow.myneighbourhood;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View;

public class JoinNeighbourhood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_neighbourhood);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Join neighbourhood");
        actionBar.setDisplayHomeAsUpEnabled(true);
        RelativeLayout root = (RelativeLayout) findViewById(R.id.mainlayout);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(JoinNeighbourhood.this, "Joining an existing neighbourhood is not yet implemented", Toast.LENGTH_SHORT).show();
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
