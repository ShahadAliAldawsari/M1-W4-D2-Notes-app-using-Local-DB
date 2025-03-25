package com.example.m1w4d2localdb.appUi

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.m1w4d2localdb.localDB.Note
import kotlinx.coroutines.Job

@Composable
fun AllNotesScreen(
    notesList: List<Note>,
    isDark: MutableState<Boolean>,
    editThisNote: () -> Unit,
    deleteThisNote: () -> Job,
) {
    Header(title = "My Notes", isDark = isDark)
    if (notesList.isEmpty()) {
        Text("No Notes Yet!!")
    } else {
        LazyColumn {
            items(items = notesList) { note ->
                NoteEntityUiDesign(
                    note = note,
                    { deleteThisNote() },
                    { editThisNote() }
                )
            }
        }
    }

    //add a new note button
    FloatingActionButton(
        onClick = { },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}