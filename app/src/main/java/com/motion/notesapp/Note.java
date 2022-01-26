package com.motion.notesapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String dayOfWeek;
    private int priority;

    public Note(String title, String description, String dayOfWeek, int priority) {
        this.title = title;
        this.description = description;
        this.dayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPriority() {
        return priority;
    }
}
