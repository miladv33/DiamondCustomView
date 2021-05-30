package com.example.dimondcustomviewanimation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ProTextCustomView(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {
    private var view =
        LayoutInflater.from(context).inflate(R.layout.pro_custom_textview, this, true)
    private var proTextProperties:ProTextProperties?=null

    fun setText(properties: ProTextProperties, isRTL: Boolean) {
        this.proTextProperties = proTextProperties
        view.post {
            val startTextView = view.findViewById<TextView>(R.id.startTextView)
            val endTextView = view.findViewById<TextView>(R.id.endTextView)
            val margin = properties.screenSize * properties.startTextMargin
            if (isRTL) {
                startTextView.text = properties.startText
                endTextView.text = properties.endText
                endTextView.textSize = properties.screenSize * properties.textSize
                (startTextView.layoutParams as LayoutParams).setMargins(0,0,margin.toInt(),0)
            } else {
                startTextView.text= properties.startText
                (startTextView.layoutParams as LayoutParams).setMargins(margin.toInt(),0,0,0)
                endTextView.layoutParams.width = 0
                endTextView.hide()
            }
            startTextView.textSize = properties.screenSize * properties.textSize

        }
    }
}