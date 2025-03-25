package com.example.m1w4d2localdb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.m1w4d2localdb.appUi.AllNotesScreen
import com.example.m1w4d2localdb.appUi.NewNoteScreen
import com.example.m1w4d2localdb.localDB.Note
import com.example.m1w4d2localdb.localDB.NoteDatabase
import com.example.m1w4d2localdb.navigation.AllNotes
import com.example.m1w4d2localdb.navigation.NoteDetail
import com.example.m1w4d2localdb.ui.theme.M1W4D2LocalDBTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {


    // Initialize the database
    val noteDatabase = NoteDatabase.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val newNote = Note(title = "Long Note", content = "This is a sample note. This is a sample note.This is a sample note.This is a sample note.This is a sample note.This is a sample note.This is a sample note.")
        lifecycleScope.launch{
            // Insert a new note
            noteDatabase.noteDao().insert(newNote)

        }

        setContent {

            val navCtrl = rememberNavController()
            val isDark = remember{ mutableStateOf(value = false) }

            M1W4D2LocalDBTheme (darkTheme = isDark.value) {

                NavHost(
                    navController = navCtrl,
                    startDestination = AllNotes
                ) {
                    composable<AllNotes> {
                        var args = it.toRoute<AllNotes>()
                        AllNotesScreen(
                            notesList = noteDatabase.noteDao().getAllNotes(),
                            isDark = TODO(),
                            editThisNote = TODO(),
                            deleteThisNote =
                            lifecycleScope.launch{noteDatabase.noteDao().delete()}
                        )
                    }
                    composable<NoteDetail> {
                        val args = it.toRoute<NoteDetail>()
                        NewNoteScreen(
                            note = args.note,
                            isDark = isDark,
                            title = "Note Details"
                        )
                    }
                }
            }
        }
    }
}

