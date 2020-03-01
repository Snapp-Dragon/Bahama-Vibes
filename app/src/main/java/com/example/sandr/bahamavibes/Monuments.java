package com.example.sandr.bahamavibes;


/*
 This class represents the monuments on Google Maps
 */

public class Monuments {

    //Fields

    private String title;// title of the monument

    private String snippet;// snippet of the monument

    private double lat;//lat coordinate

    private double longitude; //long coordinate;

    private int imageResourceId;// image  for the


    public Monuments(String title, String snippet, double lat, double longitude, int imageResourceId){

        this.title = title;

        this.snippet = snippet;

        this.lat = lat;

        this.longitude = longitude;

        this.imageResourceId = imageResourceId;
    }

    //Getters

    public String getTitle() {
        return this.title;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public double getLat() {
        return this.lat;
    }

    public double  getLongitude() {
        return this.longitude;
    }

    public int getImageResourceId() {
        return this.imageResourceId;
    }
}
