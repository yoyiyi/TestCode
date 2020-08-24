package com.yoyiyi.test.d3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp

/**
 * 类名：SportView
 * 描述：TODO
 * 时间：2020/8/24 15:00
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class SportView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val RING_COLOR = Color.GRAY
    private val HIGH_RING_COLOR = Color.RED

    private val RING_WIDTH = 20.dp
    private val ringPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val TextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val RADIUS = 150.dp


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //1.画环
        ringPaint.style = Paint.Style.STROKE
        ringPaint.color = RING_COLOR
        ringPaint.strokeWidth = RING_WIDTH
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, ringPaint)

        //1.画进度条
        ringPaint.color = HIGH_RING_COLOR
        ringPaint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2f - RADIUS,
            height / 2f - RADIUS,
            width / 2f + RADIUS,
            height / 2f + RADIUS,
            180f,
            180f,
            false,
            ringPaint
        )

    }

}
