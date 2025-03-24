package com.example.m1w4d2localdb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.example.m1w4d2localdb.localDB.Note
import com.example.m1w4d2localdb.localDB.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    // Initialize the database
    val noteDatabase = NoteDatabase.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (noteDatabase.noteDao().isEmpty()){
            //call empty screen
        }else{
            //call screen with notes list
        }

        lifecycleScope.launch{
            // Insert a new note
            val newNote = Note(title = "First Note", content = "This is a sample note.")
            noteDatabase.noteDao().insert(newNote)

        }
    }
}

