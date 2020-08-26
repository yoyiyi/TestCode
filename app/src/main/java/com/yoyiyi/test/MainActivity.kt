package com.yoyiyi.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //15 动画
        /*var animator1 = ObjectAnimator.ofFloat(cv, "scaleX", 0.5f, 2f)
        var animator2 = ObjectAnimator.ofFloat(cv, "scaleY", 0.5f, 2f)
        animator1.duration = 3000
        animator1.startDelay = 500
        animator1.repeatCount = -1
        animator1.repeatMode = REVERSE

        animator2.duration = 3000
        animator2.startDelay = 500
        animator2.repeatCount = -1
        animator2.repeatMode = REVERSE
        var set = AnimatorSet()
        set.playTogether(animator1, animator2)
        set.start()*/

    }
}
