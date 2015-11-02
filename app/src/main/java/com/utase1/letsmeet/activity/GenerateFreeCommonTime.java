package com.utase1.letsmeet.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.utase1.letsmeet.R;
import com.utase1.letsmeet.dto.ParticipantDetails;
import com.utase1.letsmeet.dto.TimeParticipantMap;
import com.utase1.letsmeet.dto.DataWrapper;


import java.util.ArrayList;



//import android.<span class="IL_AD" id="IL_AD6">graphics</span>.Color;

//import android.<span class="IL_AD" id="IL_AD6">graphics</span>.Color;

/**
 * Created by Ashay Rajimwale on 10/18/2015.
 */
public class GenerateFreeCommonTime extends Activity {
    RelativeLayout relativeLayout;
    TableLayout tl;
    TableRow tr;
    TextView particpants, timeslot;
    ArrayList<TimeParticipantMap> freeParticipants;
    Button schedule;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        DataWrapper dataReceived = (DataWrapper) bundle.getSerializable("finalParticipants");
        if (dataReceived.getParticipants() != null) {
            freeParticipants = dataReceived.getParticipants();

        }
        setContentView(R.layout.activity_free_time_display);
        tl = (TableLayout) findViewById(R.id.maintable);
        tl.setStretchAllColumns(true);
        addData();
    }


    /**
     * This function add the data to the table
     **/
    public void addData() {
        if (freeParticipants != null) {
            int j=0;
            for (TimeParticipantMap freeParticipant : freeParticipants) {
                j++;
                addTimeHeader();
                addTimeValue(freeParticipant);
                //  valueTV.setTextColor(Color.GREEN);
                timeslot.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                timeslot.setPadding(5, 5, 5, 5);
                timeslot.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

                tr=new TableRow(this);

                schedule=new Button(this);
                schedule.setText("Schedule");
                schedule.setTextSize(14);

                schedule.setId(j);
                schedule.setTextColor(getResources().getColor(android.R.color.white));
                schedule.setBackgroundColor(getResources().getColor(R.color.bg_main));



                tr = new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tr.addView(timeslot);
                tr.addView(schedule); // Adding textView to tablerow.
                int heightDp = (int) 120;
                int widthDp = (int) 80;
                TableRow.LayoutParams bLp = new TableRow.LayoutParams(widthDp,heightDp);
                schedule.setLayoutParams(bLp);

                tl.addView(tr, new TableLayout.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                addParticipantHeader();



                for (ParticipantDetails freeParticipant1 : freeParticipant.getParticipantDetails()) {

                    tr = new TableRow(this);
                    tr.setLayoutParams(new TableRow.LayoutParams(
                            TableRow.LayoutParams.FILL_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    particpants = new TextView(this);
                    particpants.setText(freeParticipant1.getParticipantName());
                    // companyTV.setTextColor(Color.RED);
                    particpants.setTextColor(getResources().getColor(android.R.color.white));
                    particpants.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                    particpants.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                    particpants.setPadding(5, 5, 5, 5);
                    tr.addView(particpants);  // Adding textView to tablerow.
                    tl.addView(tr, new TableLayout.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    View view=new View(this);
                    view.setBackgroundColor(Color.GRAY);
                    view.setMinimumHeight(4);

                    tr = new TableRow(this);
                    tr.setLayoutParams(new TableRow.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tr.addView(view); // Adding textView to tablerow.

                    tl.addView(tr, new TableLayout.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                }




            }
        }
    }

    private void addTimeValue(TimeParticipantMap freeParticipant) {
        tr = new TableRow(this);
        timeslot = new TextView(this);
        if (freeParticipant.getTimeSlot() > 12)
        {
            timeslot.setText(freeParticipant.getTimeSlot() + "PM");
            timeslot.setTextColor(getResources().getColor(android.R.color.white));
        }
        else
        {
            timeslot.setText(freeParticipant.getTimeSlot() + "AM");
            timeslot.setTextColor(getResources().getColor(android.R.color.white));
        }

    }

    private void addTimeHeader() {
        tr = new TableRow(this);
        TextView timerow = new TextView(this);
        timerow.setText("\t \t \t Time:");
        timerow.setTextColor(getResources().getColor(android.R.color.white));
        timerow.setBackgroundColor(getResources().getColor(R.color.bg_main));
        timerow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
        timerow.setPadding(5, 5, 5, 0);
        timerow.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(timerow); // Adding textView to tablerow.
        tl.addView(tr, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }

    private void addParticipantHeader()     /** This function add the headers to the <span class="IL_AD" id="IL_AD9">table</span> **/
    {

        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView participantRow = new TextView(this);
        participantRow.setText(" \t \t \t Participants");
        participantRow.setTextColor(getResources().getColor(android.R.color.white));
        participantRow.setBackgroundColor(getResources().getColor(R.color.bg_main));
        participantRow.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        participantRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        participantRow.setPadding(5, 5, 5, 0);
        tr.addView(participantRow);  // Adding textView to tablerow.

        tl.addView(tr, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));



    }

}
