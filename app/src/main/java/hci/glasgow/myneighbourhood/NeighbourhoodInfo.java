package hci.glasgow.myneighbourhood;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import models.Neighbourhood;

public class NeighbourhoodInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbourhood_info);

        final Neighbourhood neighbourhood = (Neighbourhood) getIntent().getSerializableExtra("Neighbourhood");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(neighbourhood.getName());
        actionBar.setDisplayHomeAsUpEnabled(true);
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
