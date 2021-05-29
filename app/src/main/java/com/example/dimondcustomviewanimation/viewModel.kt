package com.example.dimondcustomviewanimation

import androidx.lifecycle.ViewModel

class viewModel:ViewModel() {
    
    fun getAnimationProperties():DiamondAnimationProperties{
        return DiamondAnimationProperties.Fast
    }
}