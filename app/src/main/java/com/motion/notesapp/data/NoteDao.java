package com.motion.notesapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.motion.notesapp.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT*FROM Note")
    List<Note> getAllNote();

    @Insert
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM Note")
    void deleteAllNote();
}
