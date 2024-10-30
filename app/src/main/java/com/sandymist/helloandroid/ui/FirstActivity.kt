package com.sandymist.helloandroid.ui

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sandymist.helloandroid.ui.theme.HelloAndroidTheme
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        MainScope().launch {
            delay(20000)
            val xxx = this@FirstActivity.fragmentManager
            println("++++ Activity is $this, setting e2e, xxx $xxx")
        }

        setContent {
            HelloAndroidTheme {
                FirstScreen("First",  Modifier, this)
            }
        }
    }
}

@Composable
fun FirstScreen(name: String, modifier: Modifier = Modifier, activity: ComponentActivity) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Hello, $name!")
        Button(
            onClick = {
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Go back")
        }
    }
}