package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adder = Adder()
        adder.add(4, 90)
        /*
        val ex1 = Executors.newSingleThreadExecutor()
        ex1.submit {
            println("++++ I am ex1 task")
        }
        val ex2 = Executors.newSingleThreadExecutor()
        ex2.submit {
            println("++++ I am ex2 task")
        }
        val ex3 = Executors.newSingleThreadExecutor()
        ex3.submit {
            println("++++ I am ex3 task")
        }

        ex3.execute {
            println("++++ I am ex3 SECOND task")
        }
        ex2.execute {
            println("++++ I am ex2 SECOND task")
        }
        ex1.execute {
            println("++++ I am ex1 SECOND task")
        }

        println("++++ EX1 $ex1")
        println("++++ EX2 $ex2")
        println("++++ EX3 $ex3")
         */

        runBlocking {
            CoroutineScope(kotlin.coroutines.coroutineContext).launch {
                val connectivity = Connectivity(applicationContext)
                connectivity.status.collect {
                    println("++++ CR1: NET STATUS: $it")
                }
            }

            CoroutineScope(kotlin.coroutines.coroutineContext).launch {
                val connectivity = Connectivity(applicationContext)
                connectivity.status.collect {
                    println("++++ CR2: NET STATUS: $it")
                }
            }
        }
    }
}