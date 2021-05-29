package com.example.dimondcustomviewanimation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout


class PlayProCustomView(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {
    var view: View = LayoutInflater.from(context).inflate(R.layout.play_pro_custom_view, this, true)
    private var diamondAnimationProperties: DiamondAnimationProperties? = null
    fun setup(diamondAnimationProperties: DiamondAnimationProperties) {
        if (this.diamondAnimationProperties != null) return // prevent call the method again
        this.diamondAnimationProperties = diamondAnimationProperties
        val diamondCustomView = view.findViewById<DiamondCustomView>(R.id.diamondCustomView)
        val textView = view.findViewById<ProTextCustomView>(R.id.textView)
        diamondCustomView.setup(diamondAnimationProperties, object : IAnimationDone {
            override fun done() {
                changeSizeAnimation(textView, diamondAnimationProperties.textInterpolator, 0)
            }
        })
    }
}