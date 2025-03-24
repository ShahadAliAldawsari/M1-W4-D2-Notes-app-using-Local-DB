package com.example.m1w4d2localdb.appUi

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.m1w4d2localdb.localDB.Note

@Composable
fun AllNotesScreen(notesList:List<Note>, isDark:MutableState<Boolean>){
    Header(title = "My Notes", isDark = isDark)
    if (notesList.isEmpty()){
        Text("No Notes Yet!!")
    }else{
        //Lazy Column
        
    }
}