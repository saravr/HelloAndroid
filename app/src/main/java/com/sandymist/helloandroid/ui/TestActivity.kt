package com.sandymist.helloandroid.ui

import android.os.Bundle
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sandymist.helloandroid.R
import timber.log.Timber

class TestActivity: AppCompatActivity() {
    private var counter = 0
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        counter++

        button = findViewById(R.id.button)
        button.setOnClickListener {
            Timber.d("++++ Btn clicked: $counter")
        }

        Thread {
            Timber.d("++++ Is main 1? " + (Looper.getMainLooper() == Looper.myLooper()))
            Thread.sleep(5000)
            // Simulate long-running operation
            runOnUiThread {
                Timber.d("++++ Is main 2? " + (Looper.getMainLooper() == Looper.myLooper()))
                // Update UI
            }
        }.start()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("++++ Counter: $counter")
    }

    override fun onDestroy() {
        super.onDestroy()
        button.setOnClickListener(null)
    }
}
