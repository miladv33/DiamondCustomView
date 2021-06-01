package com.example.dimondcustomviewanimation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout

class DiamondCustomView(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {
    private var view = LayoutInflater.from(context).inflate(R.layout.diamond_custom_view, this, true)
    private var diamondAnimationProperties: DiamondAnimationProperties? = null
    private var diamondAnimation: DiamondAnimation? = null

    fun setup(diamondAnimationProperties: DiamondAnimationProperties,iAnimationDone: IAnimationDone) {
        this.diamondAnimationProperties = diamondAnimationProperties
        if (diamondAnimation == null)
            diamondAnimation = DiamondAnimation(diamondAnimationProperties)
        if (!diamondAnimationProperties.isRTL) {
            view.findViewById<View>(R.id.first_line).rotation = 180F
            view.findViewById<View>(R.id.second_line).rotation = 180F
            view.findViewById<View>(R.id.third_line).rotation = 180F
            (view.findViewById<View>(R.id.purple_background).layoutParams as ConstraintLayout.LayoutParams).setMargins(0,0,diamondAnimationProperties.endX,0)
            (view.findViewById<View>(R.id.white_background).layoutParams as ConstraintLayout.LayoutParams).setMargins(0,0,diamondAnimationProperties.endX,0)
        } else {
            (view.findViewById<View>(R.id.purple_background).layoutParams as ConstraintLayout.LayoutParams).setMargins(diamondAnimationProperties.endX, 0, 0, 0)
            (view.findViewById<View>(R.id.white_background).layoutParams as ConstraintLayout.LayoutParams).setMargins(diamondAnimationProperties.endX, 0, 0, 0)
        }

        startAnimation(iAnimationDone)
    }

    private fun startAnimation(iAnimationDone: IAnimationDone) {
        if (diamondAnimation == null) return
        diamondAnimation?.startAnimation(view,iAnimationDone)
    }

}