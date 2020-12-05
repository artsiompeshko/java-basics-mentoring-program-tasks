package com.apeshko.javacore.task_05.model;

import com.apeshko.javacore.task_05.annotations.ThisCodeSmells;
import com.apeshko.javacore.task_05.annotations.UseStackOnly;

public class Airport {
    @UseStackOnly
    private String name;
    @ThisCodeSmells
    private long latitude;
    @ThisCodeSmells
    private long longitude;

    public Airport(String name, long latitude, long longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
