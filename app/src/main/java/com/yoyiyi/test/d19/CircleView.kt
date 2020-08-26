package com.yoyiyi.test.d19

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp

/**
 * 类名：SquareImageView
 * 描述：TODO
 * 时间：2020/8/26 10:55
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val PADDING = 100.dp
    private val RADIUS = 100.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var size = (((PADDING + RADIUS)) * 2).toInt()
        val width = resolveSize(size, widthMeasureSpec)
        val height = resolveSize(size, heightMeasureSpec)
        setMeasuredDimension(width, height)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)
    }
}
