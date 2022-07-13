package com.example.helloandroid

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    /*@get:Rule
    val rule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)*/
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.helloandroid", appContext.packageName)
        //val intent = Intent(Intent.ACTION_VIEW)
        //rule.launchActivity(intent)
        val adder = Adder()
        adder.add(1, 2)
    }
}