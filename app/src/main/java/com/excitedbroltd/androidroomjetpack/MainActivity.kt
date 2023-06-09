package com.excitedbroltd.androidroomjetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.excitedbroltd.androidroomjetpack.model.NoteModel
import com.excitedbroltd.androidroomjetpack.mvvm.NoteViewModel
import com.excitedbroltd.androidroomjetpack.mvvm.NoteViewModelFactory
import com.excitedbroltd.androidroomjetpack.ui.theme.AndroidRoomJetpackTheme
import myNote


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: NoteViewModel
    private lateinit var viewModelFactory: NoteViewModelFactory
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModelFactory = NoteViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory)[NoteViewModel::class.java]
        setContent {
            AndroidRoomJetpackTheme {
                Column() {
                    basicSetUp()
                    listShow()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun basicSetUp() {
        var title by remember {
            mutableStateOf("")
        }
        var desc by remember {
            mutableStateOf("")
        }
        var timeStamp by remember {
            mutableStateOf(0L)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            TextField(
                value = title,
                onValueChange = {
                    title = it
                },
                label = {
                    Text(text = "Enter title")
                },
                maxLines = 1,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = desc,
                onValueChange = {
                    desc = it
                },
                label = {
                    Text(text = "Enter Description")
                },
                maxLines = 5,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    viewModel.addNote(
                        NoteModel(
                            0,
                            System.currentTimeMillis(),
                            title,
                            desc
                        )
                    )
                    title = ""
                    desc = ""

                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {
                Text(text = "Submit")
            }
        }
    }


    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun listShow() {
        var hithere by remember {
            mutableStateOf(true)
        }
        if (hithere) {
            Log.d(TAG, "listShow: $hithere")
        }
        var id by remember {
            mutableStateOf(1)
        }
        var allNotes: MutableState<List<NoteModel>> = mutableStateOf(listOf())
        viewModel.getNotes().observe(this) {
            allNotes.value = it
        }

        LazyColumn {
            items(allNotes.value) { item ->
                myNote(noteModel = item) {
                    // if (!hithere) hithere = true
                    Log.d(TAG, "listShow: called")
                }

            }
        }

    }

    @Composable
    @Preview(showBackground = true)
    fun MyAlertDialog(id: Int = 0) {
        //  Log.d(TAG, "MyAlertDialog: $id")
        Card(
            modifier = Modifier.padding(10.dp)
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "What do you want to do?")
            Row() {
                OutlinedButton(onClick = {}) {
                    Text(text = "Delete Note")
                }
                OutlinedButton(onClick = { }) {
                    Text(text = "Update Note")
                }
            }
        }
    }

    @Composable
    //  @Preview(showBackground = true, showSystemUi = true)
    fun showBasicSetup() {
        basicSetUp()
        // listShow()
    }

}