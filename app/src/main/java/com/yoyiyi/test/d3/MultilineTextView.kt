package com.yoyiyi.test.d3

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp
import com.yoyiyi.test.R

/**
 * 类名：MultilineTextView
 * 描述：TODO
 * 时间：2020/8/24 16:50
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */

class MultilineTextView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tristique urna tincidunt maximus viverra. Maecenas commodo pellentesque dolor ultrices porttitor. Vestibulum in arcu rhoncus, maximus ligula vel, consequat sem. Maecenas a quam libero. Praesent hendrerit ex lacus, ac feugiat nibh interdum et. Vestibulum in gravida neque. Morbi maximus scelerisque odio, vel pellentesque purus ultrices quis. Praesent eu turpis et metus venenatis maximus blandit sed magna. Sed imperdiet est semper urna laoreet congue. Praesent mattis magna sed est accumsan posuere. Morbi lobortis fermentum fringilla. Fusce sed ex tempus, venenatis odio ac, tempor metus."
    private val IMAGE_SIZE = 200.dp.toInt()
    private val IMAGE_PADDING = 50.dp

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            textSize = 16.dp
        }

    private val imgPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(getAvatar(IMAGE_SIZE), (width - IMAGE_SIZE).toFloat(), IMAGE_PADDING, imgPaint)
        val fm = textPaint.fontMetrics
        val measuredWidth = floatArrayOf(0f)

        var start = 0
        var end: Int
        var count: Int

        var verticalOffset = -fm.top
        var maxWidth: Float

        while (start < text.length) {
            maxWidth = if (verticalOffset + fm.bottom < IMAGE_PADDING
                || verticalOffset + fm.top > IMAGE_PADDING + IMAGE_SIZE
            ) {
                width.toFloat()
            } else {
                width.toFloat() - IMAGE_SIZE
            }
            count = textPaint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            end = start + count
            canvas.drawText(text, start, end, 0f, verticalOffset, textPaint)
            start += count
            verticalOffset += textPaint.fontSpacing
        }

    }

    /**
     * 获取头像
     */
    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
    }
}

