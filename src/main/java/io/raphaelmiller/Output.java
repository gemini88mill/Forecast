package io.raphaelmiller;

import com.google.gson.JsonObject;

/**
 * Created by raphael on 1/28/15.
 */
public class Output {

    private String temp;
    private String location;
    private String feelsLike;
    private String localTime;
    private String windGust;

    public Output(String temp, String location, String feelsLike, String localTime, String windGust) {
        this.temp = temp;
        this.location = location;
        this.feelsLike = feelsLike;
        this.localTime = localTime;
        this.windGust = windGust;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public void setWindGust(String windGust) {
        this.windGust = windGust;
    }


    public String output(){
        return "Current Temp:\t " + temp + "\nLocal Time:\t\t " + localTime + "\nLocation:\t\t " + location +
                "\nFeels Like:\t\t " + feelsLike + "\nWind:\t\t\t " + windGust;
    }
}
