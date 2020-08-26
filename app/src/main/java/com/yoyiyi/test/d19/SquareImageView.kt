package com.yoyiyi.test.d19

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import kotlin.math.min

/**
 * 类名：SquareImageView
 * 描述：TODO
 * 时间：2020/8/26 10:55
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class SquareImageView(context: Context, attrs: AttributeSet) : ImageView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)


    }
}
