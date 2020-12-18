package com.jeranfox.composerepro

import android.os.Bundle
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
        return SimpleButton("Button $buttonIndex")
    }
}

class SimpleButton(
    private val text: String,
) {

    @Composable
    fun Render() {
        Button({ println(text) }) {
            Text(text)
        }
    }
}
