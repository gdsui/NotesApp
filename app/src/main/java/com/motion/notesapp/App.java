package com.motion.notesapp;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.motion.notesapp.data.NoteDataBase;

public class App extends Application {
 public static NoteDataBase dataBase;
    @Override
    public void onCreate() {
        super.onCreate();
        dataBase= Room.databaseBuilder(getApplicationContext(), NoteDataBase.class,"noteDB").allowMainThreadQueries().build();
    }
}
