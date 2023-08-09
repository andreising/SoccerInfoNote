package com.andreisingeleytsev.soccernotebet.ui.screens.notes_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.soccernotebet.data.room.entities.NoteItem
import com.andreisingeleytsev.soccernotebet.ui.theme.MainColor
import com.andreisingeleytsev.soccernotebet.ui.theme.Secondary



// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
// cardiff
@Composable
fun MyNotesScreen(noteScreenViewModel: NoteListViewModel = hiltViewModel()) {
    val mainList = noteScreenViewModel.noteList.collectAsState(initial = emptyList())
    if (noteScreenViewModel.isListNote.value) {
        DefaultContent(mainList){
            noteScreenViewModel.onEvent(it)
        }
    } else {
        MyContent()
    }
// override3213214
    // override4132531534
    // override341543223
    // overrideergwgweg
    // overridert2 1
    // override5 125 125 12
    // override551235 325 1
    // original
    // original
    // original
    // original
    // original

}

@Composable
fun DefaultContent(
    array: State<List<NoteItem>>,
    vm: NoteListViewModel = hiltViewModel(),
    terminateNote: (NoteListEvent) -> Unit
) {
    Column(Modifier.fillMaxSize().background(MainColor), horizontalAlignment = Alignment.CenterHorizontally) {
        // override
        // override111
        // override123231
        // override44343
        // override54356346
        // override64654654
        // override56465465465464
        LazyColumn(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(600.dp)
                .background(Color.LightGray),
        ) {
            items(array.value) { item ->
                NoteItem(item){noteListEvent ->
                    terminateNote(noteListEvent)
                }
            }
        }
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clickable {
                    vm.onEvent(NoteListEvent.CreateNote)
                }
                )
        Text(
            text = "Add note",
            color = Color.White
        )
    }
// override3213214
    // override4132531534
    // override341543223
    // overrideergwgweg
    // overridert2 1
    // override5 125 125 12
    // override551235 325 1
    // original
    // original
    // original
    // original
    // original
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyContent(
    viewModel: NoteListViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)
    ) {

        Card(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                )  {
                    TextField(
                        modifier = Modifier.weight(1f),
                        value = viewModel.name,
                        onValueChange = {name ->
                            viewModel.name = name
                        },
                        label = {
                            Text(
                                text = "Title",
                                fontSize = 14.sp)
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = MainColor,
                            containerColor = Color.White
                        ),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    IconButton(
                        modifier = Modifier.padding(top = 10.dp, end = 3.dp),
                        onClick = {
                            viewModel.onEvent(
                                NoteListEvent.OnCreateNote(
                                    viewModel.name,
                                    viewModel.title
                                )
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "img_add",
                            tint = Secondary
                        )
                    }
                }
                TextField(
                    modifier = Modifier.fillMaxSize(),
                    value = viewModel.title,
                    onValueChange = { title ->
                        viewModel.title = title
                    },
                    label = {
                        Text(
                            text = "Text",
                            fontSize = 14.sp
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}