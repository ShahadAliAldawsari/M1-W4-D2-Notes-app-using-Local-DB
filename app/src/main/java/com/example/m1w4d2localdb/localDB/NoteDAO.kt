package com.example.m1w4d2localdb.localDB

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert
    //Create: Insert new notes into the database
    suspend fun insert(note: Note)

    //Update: Update existing note content
    @Update
    suspend fun update(note: Note)

    //Delete: Remove notes from the database
    @Delete
    suspend fun delete(note: Note)

    //Read: Query all notes
    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Note>

    //Read: Query individual notes by ID
    @Query("SELECT * FROM notes WHERE id=:id")
    fun getNoteById(id:Long): Note

    //Check if the notes DAO is empty
    @Query("SELECT (SELECT COUNT(*) FROM notes) == 0")
    fun isEmpty(): Boolean

}