package com.example.dimondcustomviewanimation

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Point
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Interpolator
import java.util.concurrent.DelayQueue

fun getScreenSize(context: Context): ScreenSize? {
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val screenSize = Point()
    display.getRealSize(screenSize)
    return ScreenSize(screenSize.x, screenSize.y)
}

fun View.fadeIn(duration: Long = 700, animationListener: Animation.AnimationListener? = null){
    val fadIn = getFadInAnimation(duration)
    fadIn.setAnimationListener(object : Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {
            animationListener?.onAnimationRepeat(animation)
        }

        override fun onAnimationEnd(animation: Animation?) {
            animationListener?.onAnimationEnd(animation)
        }

        override fun onAnimationStart(animation: Animation?) {
            this@fadeIn.show()
            animationListener?.onAnimationStart(animation)
        }

    })
    this.startAnimation(fadIn)
}

fun View.getFadInAnimation(duration: Long = 700): AlphaAnimation {
    val fadIn = AlphaAnimation(0f, 1f)
    fadIn.interpolator = AccelerateInterpolator() //and this
    fadIn.duration = duration
    return fadIn
}

fun View.fadOut(duration: Long = 700,delay:Long = 0,iAnimationDone: IAnimationDone? = null) {
    val fadeOut = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = AccelerateInterpolator() //and this
    fadeOut.duration = duration
    fadeOut.setAnimationListener(object :Animation.AnimationListener{
        override fun onAnimationRepeat(animation: Animation?) {


        }

        override fun onAnimationEnd(animation: Animation?) {
            this@fadOut.hide()
            iAnimationDone?.done()
        }

        override fun onAnimationStart(animation: Animation?) {

        }

    })
    this.startAnimation(fadeOut)
}

fun View.getFadeOutAnimation(duration: Long = 700):AlphaAnimation {
    val fadeOut = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = AccelerateInterpolator() //and this
    fadeOut.duration = duration
    return fadeOut
}

fun View.show(): View {
    if (Looper.myLooper() != Looper.getMainLooper()) {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            if (visibility != View.VISIBLE) {
                visibility = View.VISIBLE
            }
        }
    } else {
        if (visibility != View.VISIBLE) {
            visibility = View.VISIBLE
        }
    }
    return this
}

fun View.hide(): View {
    if (Looper.myLooper() != Looper.getMainLooper()) {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            if (visibility != View.INVISIBLE) {
                visibility = View.INVISIBLE
            }
        }
    } else {
        if (visibility != View.INVISIBLE) {
            visibility = View.INVISIBLE
        }
    }
    return this
}

fun View.remove(): View {
    if (Looper.myLooper() != Looper.getMainLooper()) {
        val handler = Handler(Looper.getMainLooper())
        handler.post {
            if (visibility != View.GONE) {
                visibility = View.GONE
            }
        }
    } else {
        if (visibility != View.GONE) {
            visibility = View.GONE
        }
    }
    return this
}

fun changeSizeAnimation(viewToIncreaseHeight: View, interpolator: Interpolator, delay: Long, animatorListener:Animator.AnimatorListener? = null) {
    var changedWith = 0
    val anim =
        ValueAnimator.ofInt(0, viewToIncreaseHeight.measuredWidth)
    anim.addUpdateListener { valueAnimator ->
        val value = valueAnimator.animatedValue as Int
        val layoutParams: ViewGroup.LayoutParams = viewToIncreaseHeight.layoutParams
        changedWith = value
        layoutParams.width = changedWith
        viewToIncreaseHeight.layoutParams = layoutParams
    }
    anim.addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {
            animatorListener?.onAnimationRepeat(animation)
        }

        override fun onAnimationEnd(animation: Animator?) {
            viewToIncreaseHeight.layoutParams.width = changedWith
            animatorListener?.onAnimationEnd(animation)
        }

        override fun onAnimationCancel(animation: Animator?) {
            animatorListener?.onAnimationCancel(animation)
        }

        override fun onAnimationStart(animation: Animator?) {
            viewToIncreaseHeight.layoutParams.width = 1
            viewToIncreaseHeight.invalidate()
            viewToIncreaseHeight.visibility = View.VISIBLE
            animatorListener?.onAnimationStart(animation)
        }

    })
    anim.interpolator = interpolator
    anim.startDelay = delay
    anim.duration = 1000
    anim.start()
}

