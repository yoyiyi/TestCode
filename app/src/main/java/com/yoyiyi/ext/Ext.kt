package com.yoyiyi.ext

import android.content.res.Resources
import android.util.TypedValue

/**
 * 类名：Ext
 * 描述：TODO
 * 时间：2020/8/24 9:33
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
val Float.dp
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

val Int.dp
    get() = this.toFloat().dp