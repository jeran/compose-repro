package com.jeranfox.composerepro

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.setContent

class MainActivity : AppCompatActivity() {

    private var buttonIndex = 0
    private var simpleButton by mutableStateOf(createButton())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Button(onClick = {
                    buttonIndex++
                    simpleButton = createButton()
                }) {
                    Text("Switch Buttons")
                }
                simpleButton.Render()
            }
        }
    }

    private fun createButton(): SimpleButton {
        return SimpleButton(this, "Button $buttonIndex")
    }
}

class SimpleButton(
    private val context: Context,
    private val text: String,
) {

    @Composable
    fun Render() {
        Button({ Toast.makeText(context, text, Toast.LENGTH_SHORT).show() }) {
            Text(text)
        }
    }
}
