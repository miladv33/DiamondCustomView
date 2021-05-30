package com.example.dimondcustomviewanimation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val playProCustomView = findViewById<PlayProCustomView>(R.id.play_pro_customView)
        val animationProperties = DiamondAnimationProperties.Fast
        val proTextProperties = ProTextProperties.RELATIVE_TO_SCREEN
        val language = Locale.getDefault().displayLanguage;
        val size  = getScreenSize(this)
        if (language == "English") {
            animationProperties.startX = +600
            animationProperties.isRTL = false
            proTextProperties.textSize = 0.017F
            proTextProperties.viewWith = 0.78F
            proTextProperties.startTextMargin = 0.04F

        } else {
            animationProperties.startX = -600
            animationProperties.isRTL = true
            proTextProperties.textSize = 0.016F
            proTextProperties.viewWith = 0.75F
            proTextProperties.startTextMargin = 0.08F
        }
        size?.let {
            proTextProperties.screenSize = it.width.toFloat()
        }
        proTextProperties.startText = getString(R.string.start_play_pro_text)
        proTextProperties.endText = getString(R.string.end_play_pro_text)
        button.setOnClickListener {
            playProCustomView.setup(DiamondAnimationProperties.Fast,proTextProperties)
        }
    }
}