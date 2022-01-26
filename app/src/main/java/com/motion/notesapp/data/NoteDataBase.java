package com.motion.notesapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.motion.notesapp.Note;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
