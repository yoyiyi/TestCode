package com.yoyiyi.test.d17

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.yoyiyi.ext.dp
import com.yoyiyi.test.R

/**
 * 类名：MaterialEditText
 * 描述：TODO
 * 时间：2020/8/26 13:49
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class MaterialEditText(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val TEXT_SIZE = 12.dp
    private val TEXT_MARGIN = 8.dp
    private val HORIZONTAL_OFFSET = 5.dp
    private val VERTICAL_OFFSET = 23.dp
    private val EXTRA_VERTICAL_OFFSET = 16.dp
    private var floatingLabelShow = false

    var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }

    private val animator by lazy {
        ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0f, 1f)
    }

    private var useFloatingLabel = false
        set(value) {
            if (value != field) {
                field = value
                if (field) {
                    setPadding(paddingLeft, (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
                } else {
                    setPadding(paddingLeft, (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
                }
            }
        }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        if (floatingLabelShow && text.isNullOrEmpty()) {
            floatingLabelShow = false
            animator.reverse()
        } else if (!floatingLabelShow && !text.isNullOrEmpty()) {
            floatingLabelShow = true
            animator.start()
        }

    }


    init {
        paint.textSize = TEXT_SIZE
        paint.color = Color.GREEN
        //设置上 Padding 预留空间

        val ta = context.obtainStyledAttributes(R.styleable.MaterialEditText)
        useFloatingLabel = ta.getBoolean(R.styleable.MaterialEditText_useFloatingLabel, true)
        ta.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVertivalValue = VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
        canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, currentVertivalValue, paint)
    }

}
