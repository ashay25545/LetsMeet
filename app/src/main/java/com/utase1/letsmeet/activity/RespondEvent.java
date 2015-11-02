package com.utase1.letsmeet.activity;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.utase1.letsmeet.R;

public class RespondEvent extends AppCompatActivity {

    private TextView _eventName;
    private TextView _eventDate;
    private TextView _eventTime;
    private TextView _eventLocation;
    private Button btnAccept;
    private Button btnDecline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respond_event);

        _eventName=(TextView)findViewById(R.id.textView3);
        _eventDate=(TextView)findViewById(R.id.textView4);
        _eventTime=(TextView)findViewById(R.id.textView5);
        _eventLocation=(TextView)findViewById(R.id.textView6);

        btnAccept = (Button) findViewById(R.id.accept_event);
        btnDecline = (Button) findViewById(R.id.decline_event);

        _eventName.setText(getIntent().getExtras().getString("EventName"));
        _eventDate.setText(getIntent().getExtras().getString("EventDate"));
        _eventTime.setText(getIntent().getExtras().getString("EventTime"));
        _eventLocation.setText(getIntent().getExtras().getString("EventLocation"));

        btnAccept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btnDecline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }

}
