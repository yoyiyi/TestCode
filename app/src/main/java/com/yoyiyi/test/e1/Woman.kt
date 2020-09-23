package com.yoyiyi.test.e1

/**
 * 类名：Woman
 * 描述：TODO
 * 时间：2020/9/23 13:09
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
data class Woman(var name: String)

fun main() {
    var w1 = Woman("test")
    var w2 = w1.copy()
    w2.name = "t"
    println(w1.toString())
    println(w2.toString())
}