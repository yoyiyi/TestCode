package com.yoyiyi.test.d1

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp

/**
 * 类名：DashboardView
 * 描述：TODO
 * 时间：2020/8/24 10:14
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class DashboardView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val RADIUS = 150f.dp
    private val OPEN_ANGLE = 120
    private val DASH_WIDTH = 2f.dp
    private val DASH_LENGTH = 10f.dp
    private val LENGTH = 120f.dp
    private val MASK = 5
    private val arcPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val arcPath = Path()

    private val dashPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dashPath = Path()
    private lateinit var pathEffect: PathEffect

    init {
        arcPaint.strokeWidth = 3.dp
        arcPaint.style = Paint.Style.STROKE
        arcPaint.color = Color.RED

        dashPaint.strokeWidth = 3.dp
        dashPaint.style = Paint.Style.STROKE
        dashPaint.color = Color.RED


        dashPath.addRect(0f, 0f, DASH_WIDTH, DASH_LENGTH, Path.Direction.CCW)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        arcPath.addArc(
            width / 2f - RADIUS, height / 2f - RADIUS, width / 2f + RADIUS, height / 2f + RADIUS,
            OPEN_ANGLE / 2f + 90, (360 - OPEN_ANGLE).toFloat()
        )
        val pathMeasure = PathMeasure(arcPath, false)
        pathEffect = PathDashPathEffect(dashPath, (pathMeasure.length - DASH_WIDTH) / 20f, 0f, PathDashPathEffect.Style.ROTATE)

    }


    override fun onDraw(canvas: Canvas) {
        //1.画弧
        canvas.drawPath(arcPath, arcPaint)
        //2.画刻度
        dashPaint.pathEffect = pathEffect
        canvas.drawPath(arcPath, dashPaint)
        dashPaint.pathEffect = null
        //3.画线
        canvas.drawLine(
            width / 2f,
            height / 2f,
            width / 2f + LENGTH * Math.cos(toRadians(MASK)).toFloat(),
            height / 2f + LENGTH * Math.sin(toRadians(MASK)).toFloat(),
            arcPaint
        )

    }

    private fun toRadians(mark: Int): Double = Math.toRadians((90 + OPEN_ANGLE / 2f + (360 - OPEN_ANGLE) / 20f * mark).toDouble())

}