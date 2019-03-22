package com.example.retrofit;

public class Hero {

    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imageurl;
    private String bio;


    public Hero(String name, String realname, String team, String imageurl) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }



    public String getImageurl() {
        return imageurl;
    }
}

