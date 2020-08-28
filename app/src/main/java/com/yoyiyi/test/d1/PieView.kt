package com.yoyiyi.test.d1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp
import java.lang.Math.cos
import java.lang.Math.sin

/**
 * 类名：DashboardView
 * 描述：TODO
 * 时间：2020/8/24 10:14
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class PieView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val RADIUS = 150.dp
    private val OFFSET = 20.dp
    private val ANGLES = floatArrayOf(60f, 90f, 150f, 60f)
    private val COLORS = listOf(
        Color.parseColor("#C2185B"),
        Color.parseColor("#00ACC1"),
        Color.parseColor("#558B2F"),
        Color.parseColor("#5D4037")
    )
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }


    override fun onDraw(canvas: Canvas) {
        var startAngle = 0f
        for ((i, v) in ANGLES.withIndex()) {
            paint.color = COLORS[i]
            if (i == 2) {
                canvas.save()
                canvas.translate(
                    OFFSET * cos(Math.toRadians(startAngle + v / 2.0)).toFloat(),
                    OFFSET * sin(Math.toRadians(startAngle + v / 2.0)).toFloat()
                )

            }
            canvas.drawArc(
                width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS, height / 2 + RADIUS
                , startAngle, v, true, paint
            )
            startAngle += ANGLES[i]
            if (i == 2) {
                canvas.restore()
            }
        }


    }


}