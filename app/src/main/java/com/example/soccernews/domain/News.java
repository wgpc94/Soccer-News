package com.example.soccernews.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {
    @PrimaryKey
    private int id;
    public String title;
    public String description;
    public String image;
    public String link;
    public boolean favorite;

    public News(String title, String description, String image, String link) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
