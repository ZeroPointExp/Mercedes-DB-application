package com.example.mercedes_db_ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.widget.TextView
import androidx.core.view.isVisible


class MainActivity : AppCompatActivity() {
        private lateinit var mercedesLogo : View
        private lateinit var phraseLe : TextView
        private lateinit var phraseMeilleur : TextView
        private lateinit var phraseOu : TextView
        private lateinit var phraseRien : TextView
        private lateinit var animation : Animation
        private lateinit var spinAnimation : RotateAnimation
        private lateinit var animationSet : AnimationSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mercedesLogo = findViewById(R.id.mercedesLogo)
        phraseLe = findViewById(R.id.PackedChainViewHeader)
        phraseMeilleur = findViewById(R.id.packedChainView2)
        phraseOu = findViewById(R.id.packedChainView3)
        phraseRien = findViewById(R.id.packedChainView4)

        //анимация лого
        mercedesLogo.startAnimation(logoAnimation())

        //анимация фразы
        animation = AnimationUtils.loadAnimation(this, R.anim.le)
        phraseLe.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(this, R.anim.meilleur)
        phraseMeilleur.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(this, R.anim.ou)
        phraseOu.startAnimation(animation)

        animation = AnimationUtils.loadAnimation(this, R.anim.rien)
        phraseRien.startAnimation(animation)

    }

    private fun logoAnimation() : AnimationSet {
        animationSet = AnimationSet(true)
        animation = AnimationUtils.loadAnimation(this, R.anim.mercedes_logo)
        animationSet.addAnimation(animation)
        animationSet.addAnimation(spinLogo())

        return animationSet
    }


    private fun spinLogo() : RotateAnimation {
       spinAnimation = RotateAnimation(0.0f, 240.0f, Animation.RELATIVE_TO_SELF,
           0.5f, Animation.RELATIVE_TO_SELF, 0.5f )
        spinAnimation.startOffset = 5500
        spinAnimation.duration = 3000

        spinAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(spinAnimation: Animation) {

            }

            override fun onAnimationEnd(spinAnimation: Animation) {
                startActivity(Intent(this@MainActivity, SecondActivity::class.java ))
                overridePendingTransition(R.anim.slidein, R.anim.slideout)
            }

            override fun onAnimationRepeat(spinAnimation: Animation) {

            }
        })

        return spinAnimation
    }
}


