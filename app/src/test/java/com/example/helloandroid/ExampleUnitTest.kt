package com.example.helloandroid

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun add1() {
        val adder = Adder()
        assertEquals(4, adder.add(2, 2))
    }

    @Test
    fun add2() {
        val adder = Adder()
        assertEquals(7, adder.add(2, 5))
    }
}