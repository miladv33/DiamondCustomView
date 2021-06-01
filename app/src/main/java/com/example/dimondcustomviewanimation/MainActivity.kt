package com.example.dimondcustomviewanimation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var playProCustomView: PlayProCustomView
    var margin = 0.10F
    val language = Locale.getDefault().displayLanguage;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val diamoddnd = findViewById<ConstraintLayout>(R.id.diamond_root)
        diamoddnd.measureViewSizeInRunTIme(object : OnGlobalLayoutMeasured {
            override fun onMeasured(with: Int, height: Int) {
                val size = with
                button = findViewById(R.id.button)
                playProCustomView = findViewById(R.id.play_pro_customView)
                val animationProperties = DiamondAnimationProperties.Fast
                val proTextProperties = ProTextProperties.RELATIVE_TO_SCREEN
                if (language == "English") {
                    animationProperties.startX = +600
                    animationProperties.endX = (size.times(margin)).toInt()
                    animationProperties.isRTL = false
                    proTextProperties.textSize = 0.02F
                    proTextProperties.viewWith = 0.66F + margin / 2
                    proTextProperties.startTextMargin = 0.07F

                } else {
                    animationProperties.startX = -600
                    animationProperties.endX = (size.times(margin)).toInt()
                    animationProperties.isRTL = true
                    proTextProperties.textSize = 0.019F
                    proTextProperties.viewWith = 0.62F + margin / 2
                    proTextProperties.startTextMargin = 0.07F
                }
                proTextProperties.screenSize = size.toFloat()
                proTextProperties.startText = getString(R.string.start_play_pro_text)
                proTextProperties.endText = getString(R.string.end_play_pro_text)
                button.setOnClickListener {
                    playProCustomView.setup(DiamondAnimationProperties.Fast, proTextProperties)
                }
            }

        })

    }


}