package com.yoyiyi.test.d15

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
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
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val RADIUS = 50.dp
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.RED
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width / 2f, height / 2f, RADIUS, paint)

    }
}
