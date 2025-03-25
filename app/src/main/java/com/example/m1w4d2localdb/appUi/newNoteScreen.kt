package com.example.m1w4d2localdb.appUi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.m1w4d2localdb.localDB.Note

@Composable
fun NewNoteScreen(
    note: Note,
    isDark: MutableState<Boolean>,
    title:String
){

    Header(isDark=isDark, title = title)

    var title by remember { mutableStateOf(note.title) }
    var content by remember { mutableStateOf(note.content) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        TextField(
            value = title,
            onValueChange = {title = it},
            label = {Text("Note Title", /*color = darkColor*/)},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//            colors = TextFieldDefaults.colors()
        )

        TextField(
            value = content,
            onValueChange = {content = it},
            label = {Text("Note Content", /*color = darkColor*/)},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//            colors = TextFieldDefaults.colors()
        )

        //save button
        Button(
            onClick = {}
        ) {
            Text("Save")
        }
    }
}