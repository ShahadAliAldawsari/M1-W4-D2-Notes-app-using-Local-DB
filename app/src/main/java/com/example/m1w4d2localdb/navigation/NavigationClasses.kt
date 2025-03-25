package com.example.m1w4d2localdb.navigation

import com.example.m1w4d2localdb.localDB.Note
import kotlinx.serialization.Serializable


@Serializable
object AllNotes

@Serializable
data class NoteDetail(
    var note: Note
)