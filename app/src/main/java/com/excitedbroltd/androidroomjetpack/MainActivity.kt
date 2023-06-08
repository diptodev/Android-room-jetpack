package com.excitedbroltd.androidroomjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.excitedbroltd.androidroomjetpack.ui.theme.AndroidRoomJetpackTheme


class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRoomJetpackTheme {
                basicSetUp()
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
                    Log.d(TAG, "basicSetUp: $title : $desc")
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {
                Text(text = "Submit")
            }
        }
    }

    @Composable
    @Preview(showBackground = true, showSystemUi = true)
    fun showBasicSetup() {
        basicSetUp()
    }

}