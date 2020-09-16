package com.yoyiyi.test.d20

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import kotlin.math.max

/**
 * 类名：TagLayout
 * 描述：TODO
 * 时间：2020/8/27 11:07
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
class TagLayout(context: Context, attributeSet: AttributeSet?) : ViewGroup(context, attributeSet) {


    //子view位置
    private val childrenBounds = mutableListOf<Rect>()


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
         var widthUsed = 0
         var heightUsed = 0
         var lineWidthUsed = 0
         var lineMaxHeight = 0



        val specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)


        children.forEachIndexed { index, child ->
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            if (specWidthMode != MeasureSpec.UNSPECIFIED && lineWidthUsed + child.measuredWidth > specWidthSize) { //换行操作
                lineWidthUsed = 0
                heightUsed += lineMaxHeight
                lineMaxHeight = 0
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            }


            if (index >= childrenBounds.size) {
                childrenBounds.add(Rect())


            }

            val childBound = childrenBounds[index]
            childBound.set(lineWidthUsed, heightUsed, lineWidthUsed + child.measuredWidth, heightUsed + child.measuredHeight)

            lineWidthUsed += child.measuredWidth
            widthUsed = max(widthUsed, lineWidthUsed)
            lineMaxHeight = max(lineMaxHeight, child.measuredHeight)
        }
        val selfWidth = widthUsed
        val selfHeight = heightUsed + lineMaxHeight
        setMeasuredDimension(selfWidth, selfHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        children.forEachIndexed { index, child ->

            child.layout(childrenBounds[index].left, childrenBounds[index].top, childrenBounds[index].right, childrenBounds[index].bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

}