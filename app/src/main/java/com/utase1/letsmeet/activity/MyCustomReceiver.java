package com.utase1.letsmeet.activity;

import android.content.BroadcastReceiver;

import com.parse.ParseBroadcastReceiver;
import com.parse.ParsePushBroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MyCustomReceiver extends ParsePushBroadcastReceiver {
	private static final String TAG = "MyCustomReceiver";

	@Override
	public void onPushOpen(Context context, Intent intent) {
		try {
			if (intent == null)
			{
				Log.d(TAG, "Receiver intent null");
			}
			else
			{
					String channel = intent.getExtras().getString("com.parse.Channel");
					JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));

					Log.d(TAG, "got action " + " on channel " + channel + " with:");
					Iterator itr = json.keys();
					while (itr.hasNext()) {
						String key = (String) itr.next();
						if (key.equals("customdata"))
						{
							if(json.getString("EventorMeeting").equals("Event")) {
								Intent pupInt = new Intent(context, RespondEvent.class);
								pupInt.putExtra("EventName", json.getString("EventName"));
								pupInt.putExtra("EventDate", json.getString("EventDate"));
								pupInt.putExtra("EventTime", json.getString("EventTime"));
								pupInt.putExtra("EventLocation", json.getString("EventLocation"));
								pupInt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								context.getApplicationContext().startActivity(pupInt);
							}
							else if(json.getString("EventorMeeting").equals("Meeting"))
							{
								Intent pupInt = new Intent(context, RespondMeeting.class);
								pupInt.putExtra("MeetName", json.getString("MeetName"));
								pupInt.putExtra("MeetDate", json.getString("MeetDate"));
								pupInt.putExtra("MeetTime", json.getString("MeetTime"));
								pupInt.putExtra("MeetLocation", json.getString("MeetLocation"));
								pupInt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								context.getApplicationContext().startActivity(pupInt);
							}
						}
						Log.d(TAG, "..." + key + " => " + json.getString(key));
					}
			}

		} catch (JSONException e) {
			Log.d(TAG, "JSONException: " + e.getMessage());
		}
	}
}
