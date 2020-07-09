package com.funkymaster.hasbni.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.funkymaster.hasbni.R

class OTPActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide() //removing the title bar
        } catch (e: NullPointerException) {
        } //catch
        setContentView(R.layout.activity_otp)
    }

}