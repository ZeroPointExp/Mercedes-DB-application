package com.example.mercedes_db_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var animation: Animation
    lateinit var slideLine : View
    lateinit var rightViewAutorization : View
    lateinit var leftViewRegistration : View
    lateinit var viewText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



    }

    override fun onStart() {
        super.onStart()
        slideLine = findViewById(R.id.slideLine)
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_dow_line)
        slideLine.startAnimation(animation)

        rightViewAutorization = findViewById(R.id.right_view)
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_up_view_right_autorization)
        rightViewAutorization.startAnimation(animation)

        leftViewRegistration = findViewById(R.id.left_view)
        animation = AnimationUtils.loadAnimation(this, R.anim.slide_down_view_left_registratin)
        leftViewRegistration.startAnimation(animation)

        viewText = findViewById(R.id.registration_text)
        animation = AnimationUtils.loadAnimation(this, R.anim.autoriz_reg_anim)
        viewText.startAnimation(animation)

        viewText = findViewById(R.id.autorization_text)
        animation = AnimationUtils.loadAnimation(this, R.anim.autoriz_reg_anim)
        viewText.startAnimation(animation)

    }



}