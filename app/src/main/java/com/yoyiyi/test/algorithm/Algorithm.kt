package com.yoyiyi.test.algorithm

/**
 * 类名：Algorithm
 * 描述：TODO
 * 时间：2020/8/25 9:27
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */

//交换
private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
}

/**
 *
 * 67. 把字符串转换成整数
 * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
 *
 * Iuput:
 * +2147483647
 * 1a33
 *
 * Output:
 * 2147483647
 * 0
 *
 */


fun strToInt(str: String?): Int {
    if (str.isNullOrBlank()) return 0
    val isNegative = str[0] == '-' // 符号判定
    var result = 0
    str.forEachIndexed jump@{ i, c ->
        if (i == 0 && (c == '+' || c == '-')) return@jump // 符号判定
        if (c < '0' || c > '9') return 0 // 非法输入
        result = result * 10 + (c - '0')
    }
    return if (isNegative) -result else result
}
