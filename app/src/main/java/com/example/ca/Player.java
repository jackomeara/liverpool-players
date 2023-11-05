package com.example.ca;

public class Player {
    private String name;
    private String position;
    private String image;
    private String appearances;
    private String goals;
    private String assists;
    private String bio;
    private String url;

    public Player(String name, String position, String image, String appearances, String goals, String assists, String bio, String url) {
        this.name = name;
        this.position = position;
        this.image = image;
        this.appearances = appearances;
        this.goals = goals;
        this.assists = assists;
        this.bio = bio;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getImage() {
        return image;
    }
    public String getAppearances() {
        return appearances;
    }
    public String getGoals() {
        return goals;
    }
    public String getAssists() {
        return assists;
    }
    public String getBio() { return bio; }
    public String getUrl() { return url; }
}
