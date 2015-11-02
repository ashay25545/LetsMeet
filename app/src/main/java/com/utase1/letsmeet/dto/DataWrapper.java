package com.utase1.letsmeet.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ashay Rajimwale on 10/18/2015.
 */
public class DataWrapper implements Serializable {

    private ArrayList<TimeParticipantMap> participants;

    public DataWrapper(ArrayList<TimeParticipantMap> data) {
        this.participants = data;
    }

    public ArrayList<TimeParticipantMap> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<TimeParticipantMap> participants) {
        this.participants = participants;
    }
}
