package com.example.blackcoffertask;

import java.io.Serializable;

public class BusinessData implements Serializable {
    String name;
    String location;
    String experience;
    String inviteStatus;
    String status;
    int image;
    int progress;

    public BusinessData(int image, String name, String location, String experience, String status, String inviteStatus, int progress) {
        this.name = name;
        this.location = location;
        this.experience = experience;
        this.inviteStatus = inviteStatus;
        this.status = status;
        this.image = image;
        this.progress = progress;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getExperience() {
        return experience;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public String getStatus() {
        return status;
    }

    public int getImage() {
        return image;
    }

    public int getProgress() {
        return progress;
    }
}
