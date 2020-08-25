package com.yoyiyi.test

import com.yoyiyi.test.algorithm.strToInt
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testStrToInt() {
        // +2147483647
        // 1a33
        println(strToInt("+2147483647"))
        println(strToInt("1a33"))

    }
}
