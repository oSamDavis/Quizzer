package com.example.quizzer;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface FlashcardDao {
    @Query("SELECT * FROM flashcard")
    List<Flashcard> getAll();

    @Insert
    void insertAll(Flashcard... flashcards);

    @Delete
    void delete(Flashcard flashcard);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Flashcard flashcard);
}
