package hci.glasgow.myneighbourhood;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import Controller.NeighbourhoodAdapter;
import Helpers.DataGenerator;
import models.*;
import models.Post;

public class MyNeighbourhood extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_neighbourhood);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.myneighbourhood_list);

        ArrayList<Neighbourhood> neighbourhoods = DataGenerator.generateNeighbourhoods();
        NeighbourhoodAdapter adapter = new NeighbourhoodAdapter(this,neighbourhoods);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Neighbourhood neighbourhood = (Neighbourhood)parent.getAdapter().getItem(position);
                Intent myIntent = new Intent(MyNeighbourhood.this, Posts.class);
                myIntent.putExtra("Neighbourhood",neighbourhood);
                MyNeighbourhood.this.startActivity(myIntent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] array = {"Create a new neighbourhood","Join an existing neighbourhood"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MyNeighbourhood.this);
                builder.setTitle("Add a Neighbourhood")
                        .setItems(array, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Intent myIntent = new Intent(MyNeighbourhood.this, CreateNeighbourhood.class);
                                        MyNeighbourhood.this.startActivity(myIntent);
                                        break;
                                    case 1:
                                        myIntent = new Intent(MyNeighbourhood.this, JoinNeighbourhood.class);
                                        MyNeighbourhood.this.startActivity(myIntent);
                                        break;
                                }

                            }
                        });
                builder.show();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.favs) {
            ArrayList<models.Post> favorites = MyApp.getFavorites();
            // package favorites in a neighbourhood so they can be displayed in the exisitng Posts list activity
            Neighbourhood neighbourhood = new Neighbourhood("Your favorite postings");
            neighbourhood.setPosts(favorites);

            Intent myIntent = new Intent(MyNeighbourhood.this, Posts.class);
            myIntent.putExtra("Neighbourhood",neighbourhood);
            MyNeighbourhood.this.startActivity(myIntent);

        } else if (id == R.id.chat) {
            Intent myIntent = new Intent(MyNeighbourhood.this, ChatActivity.class);
            MyNeighbourhood.this.startActivity(myIntent);

        }  else if (id == R.id.settings) {
            Intent myIntent = new Intent(MyNeighbourhood.this, SettingsActivity.class);
            MyNeighbourhood.this.startActivity(myIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
