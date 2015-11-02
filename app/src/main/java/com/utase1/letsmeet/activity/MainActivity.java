package com.utase1.letsmeet.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;


import com.parse.Parse;
import com.parse.ParseInstallation;
import com.utase1.letsmeet.helper.SQLiteHandler;
import com.utase1.letsmeet.helper.SessionManager;
import com.utase1.letsmeet.R;

public class MainActivity extends Activity {

    private TextView txtName;
    private Button btnLogout;
    private Button createEvent;
    private Button createMeeting;
    private Button btnMyschedule;
    private Button btnSchedule;

    private SQLiteHandler db;
    private SessionManager session;
    //private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.name);
        //txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        createEvent = (Button) findViewById(R.id.btncreateeve);
        createMeeting = (Button) findViewById(R.id.btncreatemeet);
        btnMyschedule = (Button) findViewById(R.id.mySchedule);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from SQLite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        //email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
        //txtEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        createMeeting.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        CreateMeeting.class);
                startActivity(i);
                finish();
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        CreateEvent.class);
                startActivity(i);
                finish();
            }
        });

        btnMyschedule.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        MySchedule.class);
                startActivity(i);
                finish();
            }
        });



    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
