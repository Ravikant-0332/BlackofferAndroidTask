package com.example.blackcoffertask;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class UserData implements Serializable {
    String name;
    String location;
    String distance;
    String interest;
    String status;
    String inviteStatus;
    int image;
    int progress;


    public UserData(int image, String name, String location, String distance, String interest, String status, String inviteStatus, int progress) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.distance = distance;
        this.interest = interest;
        this.status = status;
        this.inviteStatus = inviteStatus;
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
    public int getImage() {
        return image;
    }
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDistance() {
        return distance;
    }

    public String getInterest() {
        return interest;
    }

    public String getStatus() {
        return status;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

}
