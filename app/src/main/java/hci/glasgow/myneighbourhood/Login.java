package hci.glasgow.myneighbourhood;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // hide actionbar
        ActionBar actionBar =  getSupportActionBar();
        actionBar.hide();

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Login.this, MyNeighbourhood.class);
                Login.this.startActivity(myIntent);
                //remove login screen from activity stack
                Login.this.finish();
            }
        });
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // register not implemented yet
                Toast.makeText(Login.this, "Register is not yet implemented", Toast.LENGTH_SHORT).show();
            }
        });
        TextView login_continue = (TextView) findViewById(R.id.login_continue);
        login_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Login.this, MyNeighbourhood.class);
                Login.this.startActivity(myIntent);
                //remove login screen from activity stack
                Login.this.finish();
            }
        });
    }
}
