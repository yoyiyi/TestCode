package com.yoyiyi.test

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.yoyiyi.test.algorithm.strToInt
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.yoyiyi.test", appContext.packageName)
    }



}
