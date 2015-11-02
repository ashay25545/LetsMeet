package com.utase1.letsmeet.dto;

import java.io.Serializable;

/**
 * Created by Ashay Rajimwale on 10/16/2015.
 */
public class ParticipantDetails implements Serializable {

    String participantName;
    int startTime;
    int endTime;


    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
