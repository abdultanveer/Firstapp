package com.abdul.firstapp.roomdb;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface WordDao {
    @Insert
    void insert(Word word);

    @Query("SELECT * FROM Word WHERE title LIKE :word ")
    List<Word> findNote(Word word);

    @Query("SELECT * from Word ORDER BY title ASC")
    List<Word> getAllNotes();

    @Update
    void update(Word word);

    @Query("DELETE FROM Word")
    void deleteAllNotes();
}
