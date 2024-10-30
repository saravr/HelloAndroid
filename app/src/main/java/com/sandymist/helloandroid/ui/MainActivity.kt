package com.sandymist.helloandroid.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.sandymist.helloandroid.ui.theme.HelloAndroidTheme
import com.sandymist.helloandroid.viewmodels.AnotherViewModel
import com.sandymist.helloandroid.viewmodels.HelloViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val helloViewModel: HelloViewModel by viewModels()

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val hashcode = System.identityHashCode(this)
        Timber.e("++++ onCreate: activity is $this, hc $hashcode")

        val hvm = ViewModelProvider(this).get(HelloViewModel::class.java)
        Timber.e("++++ onCreate: hvm is $hvm")

        val avm = ViewModelProvider(this).get(AnotherViewModel::class.java)
        Timber.e("++++ onCreate: avm is $avm")

        setContent {
            val name by helloViewModel.name.collectAsState()

            HelloAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloScreen(
                        name = name,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HelloScreen(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Hello, $name!")
        Button(
            onClick = {
                Intent(context, FirstActivity::class.java).apply {
                    startActivity(context, this, bundleOf())
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Launch first activity!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHelloScreen() {
    HelloAndroidTheme {
        HelloScreen("Android")
    }
}