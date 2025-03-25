package com.example.m1w4d2localdb.appUi

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m1w4d2localdb.R
import com.example.m1w4d2localdb.localDB.Note

@Composable
fun NoteEntityUiDesign (note:Note, deleteThisNote:(note:Note)->Unit, editThisNote:(note:Note)->Unit) {
    val iconSize = 28.dp
    val iconColor = MaterialTheme.colorScheme.onPrimary
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // note title
                Text(
                    text = note.title,
                    modifier = Modifier,
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    //button and icon to delete a note
                    Button(
                        onClick = {deleteThisNote(note)},
                        modifier = Modifier
                            .padding(0.dp)
                            .wrapContentWidth(),
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.trash),
                            contentDescription = "trash can icon to delete a note",
                            modifier = Modifier
                                .size(iconSize),
                            tint = iconColor,
                        )
                    }

                    //button and icon to edit a note
                    Button(
                        onClick = {editThisNote(note)},
                        modifier = Modifier
                            .padding(0.dp)
                            .wrapContentWidth(),
                        colors = ButtonDefaults.buttonColors(Color.Transparent)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.pen),
                            contentDescription = "pen icon to edit a note",
                            modifier = Modifier
                                .size(iconSize),
                            tint = iconColor
                        )
                    }
                }
            }
//
//            HorizontalDivider(modifier = Modifier
//                .padding(start = 16.dp, top = 4.dp, end = 16.dp, bottom = 4.dp)
//                .weight(1f))

            Text(
                text = note.content,
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp
            )
        }
    }
}