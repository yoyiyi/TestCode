package com.yoyiyi.test.d2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp
import com.yoyiyi.test.R

/**
 * 类名：AvatarView
 * 描述：TODO
 * 时间：2020/8/24 12:44
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class AvatarView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    //头像的高
    private val IMAGE_WIDTH = 200.dp
    private val IMAGE_PADDING = 20.dp
    private val BG_WIDTH = 204.dp
    private val BG_PADDING = 18.dp
    private val xFermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        .apply {
            color = Color.RED
        }
    private val bounds = RectF(
        IMAGE_PADDING,
        IMAGE_PADDING,
        IMAGE_PADDING + IMAGE_WIDTH,
        IMAGE_PADDING + IMAGE_WIDTH
    )

    override fun onDraw(canvas: Canvas) {
        canvas.drawOval(
            BG_PADDING,
            BG_PADDING,
            BG_PADDING + BG_WIDTH,
            BG_PADDING + BG_WIDTH,
            bgPaint
        )

        val count = canvas.saveLayer(bounds, null)
        //画圆
        canvas.drawOval(bounds, bgPaint)
        //画头像
        paint.xfermode = xFermode
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
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