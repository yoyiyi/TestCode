package com.yoyiyi.test

import kotlinx.coroutines.*
import org.junit.Test

/**
 * 类名：TestCoroutines
 * 描述：TODO
 * 时间：2020/9/4 12:58
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */

class TestCoroutines {

    @Test
    fun test() {
        GlobalScope.launch(Dispatchers.Default) {

        }
        GlobalScope.async {
            delay(1000)
            return@async ""
        }

    }
}