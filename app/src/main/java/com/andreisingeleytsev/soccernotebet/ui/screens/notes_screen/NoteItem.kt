package com.andreisingeleytsev.soccernotebet.ui.screens.notes_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem
import com.andreisingeleytsev.soccernotebet.ui.theme.Secondary


@Composable
fun NoteItem(
    noteSoccerItem: NoteItem,
    onEventNote: (NoteListEvent) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 3.dp,
                top = 3.dp,
                end = 3.dp
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            start = 10.dp
                        )
                        .weight(1f), text = noteSoccerItem.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 10.dp, start = 10.dp, bottom = 10.dp
                        )
                        .weight(1f), text = noteSoccerItem.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
                IconButton(onClick = {
                    onEventNote(NoteListEvent.OnDeleteNote(noteSoccerItem))
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "img_dlt",
                        tint = Secondary
                    )
                }
                IconButton(onClick = {
                    onEventNote(NoteListEvent.OnEditNote(noteSoccerItem))
                }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "img_edit",
                        tint = Secondary
                    )
                }
            }
        }
    }
}