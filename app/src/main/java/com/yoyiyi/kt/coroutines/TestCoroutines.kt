package com.yoyiyi.kt.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 类名：TestCoroutines
 * 描述：TODO
 * 时间：2020/9/4 12:58
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */

fun main(args: Array<String>) {
    //1.suspend 可以被挂起
    //2.launch 创建 async 返回值 withContext 不创建新的 runBlocking 阻塞线程

    /*var job = GlobalScope.launch(Dispatchers.Unconfined, CoroutineStart.LAZY) {
        println("AA协程初始化完成，时间: ${System.currentTimeMillis()}")
        for (i in 1..3) {
            println("协程任务1打印第$i 次，时间: ${System.currentTimeMillis()}")
        }
        delay(500)
        for (i in 1..4) {
            println("AA协程任务2打印第$i 次，时间:${System.currentTimeMillis()}")
        }
    }
    println("初始化")
    Thread.sleep(1000)
    job.start()*/
    /*GlobalScope.launch {
        val async = GlobalScope.async {
            return@async "android"
        }
       var result =  async.await()
        println("${result}")
    }

    Thread.sleep(1000)*/

    /*runBlocking {
        delay(1000) 一定场
        println("test") 场
    }*/


/*
    GlobalScope.async {
        delay(1000)
        return@async ""
    }*/


    suspend fun getToken(): String {
        delay(1000)
        return "AA"
    }

    suspend fun getResponse(response: String): String {
        delay(1000)
        return "BB"
    }

    GlobalScope.launch {
        println("CC")
        var token = getToken()
        val response = getResponse(token)
        println("$response")
    }
    println("DD")
    Thread.sleep(5000)
    println("EE")

}