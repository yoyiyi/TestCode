package com.yoyiyi.test.d4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yoyiyi.ext.dp
import com.yoyiyi.test.R

/**
 * 类名：CameraView
 * 描述：TODO
 * 时间：2020/8/25 10:41
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class CameraView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val BITMAP_SIZE = 200.dp
    private val BITMAP_PADDING = 100.dp

    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val camera = Camera()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        camera.rotateX(30f)
        camera.setLocation(0f, 0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        /* canvas.save()
         canvas.clipRect(
             (width - bitmap.width) / 2f,
             (height - bitmap.width) / 2f,
             (width - bitmap.width) / 2f + bitmap.width,
             height / 2f
         )
         canvas.drawBitmap(bitmap, (width - bitmap.width) / 2f, (height - bitmap.width) / 2f, paint)
         canvas.restore()

         canvas.save()
         canvas.clipRect(
             (width - bitmap.width) / 2f,
             height / 2f,
             (width - bitmap.width) / 2f + bitmap.width,
             (height - bitmap.height) / 2f + bitmap.height
         )
         canvas.drawBitmap(bitmap, (width - bitmap.width) / 2f, (height - bitmap.width) / 2f, paint)
         canvas.restore()*/
        // 上半部分
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        canvas.clipRect(-BITMAP_SIZE, -BITMAP_SIZE, BITMAP_SIZE, 0f)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        // 下半部分
        canvas.save()
        canvas.translate(BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-BITMAP_SIZE, 0f, BITMAP_SIZE, BITMAP_SIZE)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2), -(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
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
