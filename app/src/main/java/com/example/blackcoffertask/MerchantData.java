package com.example.blackcoffertask;

import java.io.Serializable;

public class MerchantData implements Serializable {
    String name;
    String location;
    String status;
    int image;
    int progress;

    public MerchantData(int image, String name, String location, String status, int progress) {
        this.name = name;
        this.location = location;
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
