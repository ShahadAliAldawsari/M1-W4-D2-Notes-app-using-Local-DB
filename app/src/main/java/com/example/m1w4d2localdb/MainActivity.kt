package com.example.m1w4d2localdb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.lifecycle.lifecycleScope
import com.example.m1w4d2localdb.appUi.NoteEntityUiDesign
import com.example.m1w4d2localdb.localDB.Note
import com.example.m1w4d2localdb.localDB.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize the database
        val noteDatabase = NoteDatabase.getDatabase(this)

//        if (noteDatabase.noteDao().isEmpty()){
//            //call empty screen
//        }else{
//            //call screen with notes list
//        }

        val newNote = Note(title = "Long Note", content = "This is a sample note. This is a sample note.This is a sample note.This is a sample note.This is a sample note.This is a sample note.This is a sample note.")
        lifecycleScope.launch{
            // Insert a new note
            noteDatabase.noteDao().insert(newNote)


        }

        setContent {
//            NoteEntityUiDesign(note = newNote)
            val navCtrl= rememberNav
        }
    }
}

