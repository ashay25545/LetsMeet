package com.utase1.letsmeet.helper;


/**
 * Created by akilesh on 11/05/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

import com.utase1.letsmeet.Model.PendingModel;
import com.utase1.letsmeet.R;



public class CustomPendingAdapter extends ArrayAdapter {

    private Activity activity;
    private List<PendingModel> pendingArraylist;

    private LayoutInflater inflater;

    public CustomPendingAdapter(Context context,int resource ,List<PendingModel> results) {
        super(context,resource,results);
        pendingArraylist =results;

        inflater = LayoutInflater.from(context);

    }


    public View getView(final int position, View convertView, final ViewGroup parent) {

        final ViewHolder holder;
        notifyDataSetChanged();

        if (convertView == null){
            convertView = inflater.inflate(R.layout.pending_rows, null);
            holder = new ViewHolder();

            holder.txtMeetName = (TextView) convertView.findViewById(R.id.title);
            holder.txtLocation = (TextView) convertView.findViewById(R.id.meetingLocation);
            holder.txtDate = (TextView) convertView.findViewById(R.id.meetingDate);
            //holder.btnSch = (Button) convertView.findViewById(R.id.btnSch);
            //holder.lstSchedule = (ListView) convertView.findViewById(R.id.lst_sch_rows);

            //YOU NEED TO ADD THE BUTTON CLICK LISTNER
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtMeetName.setText(pendingArraylist.get(position).getMeetname());
        holder.txtLocation.setText(pendingArraylist.get(position).getLocation());
        holder.txtDate.setText(pendingArraylist.get(position).getDate());



        return convertView;
    }

    static class ViewHolder {

        TextView txtMeetName;
        TextView txtLocation;
        TextView txtDate;

    }

}


