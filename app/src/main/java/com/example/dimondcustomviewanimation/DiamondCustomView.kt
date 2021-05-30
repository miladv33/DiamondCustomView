package com.example.dimondcustomviewanimation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
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
        }
        startAnimation(iAnimationDone)
    }

    private fun startAnimation(iAnimationDone: IAnimationDone) {
        if (diamondAnimation == null) return
        diamondAnimation?.startAnimation(view,iAnimationDone)
    }

}