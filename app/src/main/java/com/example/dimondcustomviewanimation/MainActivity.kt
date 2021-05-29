package com.example.dimondcustomviewanimation

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val playProCustomView = findViewById<PlayProCustomView>(R.id.play_pro_customView)
        var animationProperties = DiamondAnimationProperties.Fast
        var language = Locale.getDefault().displayLanguage;
        if (language == "English") {
            animationProperties.startX = -300
        } else {
            animationProperties.startX = 300
        }
//        animationProperties.startX = if ()
        button.setOnClickListener {
            playProCustomView.setup(DiamondAnimationProperties.Fast)
//          
        }

    }

   
}