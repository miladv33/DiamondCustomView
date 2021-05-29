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

    fun setText(startText: String, endText: String, isRTL: Boolean) {
        view.post {
            val startTextView = view.findViewById<TextView>(R.id.startTextView)
            val endTextView = view.findViewById<TextView>(R.id.endTextView)
            var diamond = view.findViewById<TextView>(R.id.diamondImageView)
            if (isRTL) {
                startTextView.text = startText
                endTextView.text = endText
            } else {
                endTextView.text = startText
                startTextView.hide()
            }
        }
    }


}